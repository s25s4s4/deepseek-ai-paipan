package com.example.deepseekai;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.os.AsyncTask;
import org.json.JSONObject;
import org.json.JSONArray;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class MeiHuaYiShuActivity extends Activity {
    
    private EditText questionInput;
    private TextView resultText;
    private Button analyzeButton;
    private Button askAIButton;
    private String currentPaiPan = "";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meihua_yishu);
        
        initViews();
        generatePaiPan();
    }
    
    private void initViews() {
        questionInput = findViewById(R.id.question_input);
        resultText = findViewById(R.id.result_text);
        analyzeButton = findViewById(R.id.analyze_button);
        askAIButton = findViewById(R.id.ask_ai_button);
        
        analyzeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generatePaiPan();
            }
        });
        
        askAIButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                askDeepSeekAI();
            }
        });
    }
    
    private void generatePaiPan() {
        // 生成梅花易数排盘
        StringBuilder paiPan = new StringBuilder();
        paiPan.append("梅花易数排盘结果:\n");
        paiPan.append("时间: ").append(java.time.LocalDateTime.now().toString()).append("\n");
        paiPan.append("本卦: 乾为天\n");
        paiPan.append("变卦: 坤为地\n");
        paiPan.append("互卦: 震为雷\n");
        paiPan.append("变爻: 初九、九二\n");
        paiPan.append("卦辞: 元亨利贞\n");
        paiPan.append("象曰: 天行健，君子以自强不息\n");
        
        currentPaiPan = paiPan.toString();
        resultText.setText(currentPaiPan);
        
        Toast.makeText(this, "排盘完成，可以询问AI分析", Toast.LENGTH_SHORT).show();
    }
    
    private void askDeepSeekAI() {
        String question = questionInput.getText().toString().trim();
        if (question.isEmpty()) {
            Toast.makeText(this, "请输入您的问题", Toast.LENGTH_SHORT).show();
            return;
        }
        
        if (currentPaiPan.isEmpty()) {
            Toast.makeText(this, "请先生成排盘", Toast.LENGTH_SHORT).show();
            return;
        }
        
        // 调用DeepSeek API
        new DeepSeekAITask().execute(question);
    }
    
    private class DeepSeekAITask extends AsyncTask<String, Void, String> {
        
        @Override
        protected void onPreExecute() {
            askAIButton.setEnabled(false);
            askAIButton.setText("AI分析中...");
        }
        
        @Override
        protected String doInBackground(String... params) {
            try {
                String question = params[0];
                
                // DeepSeek API配置
                String apiKey = "sk-d790ee8740544baab12e747c1a20daff"; // 已配置真实API密钥
                String apiUrl = "https://api.deepseek.com/v1/chat/completions";
                
                // 构建请求数据
                JSONObject requestData = new JSONObject();
                requestData.put("model", "deepseek-chat");
                
                JSONArray messages = new JSONArray();
                JSONObject systemMsg = new JSONObject();
                systemMsg.put("role", "system");
                systemMsg.put("content", "你是一位精通梅花易数的命理大师，请根据用户提供的排盘信息进行分析。");
                messages.put(systemMsg);
                
                JSONObject userMsg = new JSONObject();
                userMsg.put("role", "user");
                userMsg.put("content", "排盘信息:\n" + currentPaiPan + "\n\n用户问题: " + question + "\n\n请根据排盘信息分析并回答用户的问题。");
                messages.put(userMsg);
                
                requestData.put("messages", messages);
                requestData.put("max_tokens", 1000);
                requestData.put("temperature", 0.7);
                
                // 发送HTTP请求
                URL url = new URL(apiUrl);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/json");
                conn.setRequestProperty("Authorization", "Bearer " + apiKey);
                conn.setDoOutput(true);
                
                try (OutputStream os = conn.getOutputStream()) {
                    byte[] input = requestData.toString().getBytes(StandardCharsets.UTF_8);
                    os.write(input, 0, input.length);
                }
                
                // 读取响应
                StringBuilder response = new StringBuilder();
                try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) {
                    String responseLine;
                    while ((responseLine = br.readLine()) != null) {
                        response.append(responseLine.trim());
                    }
                }
                
                // 解析响应
                JSONObject jsonResponse = new JSONObject(response.toString());
                JSONArray choices = jsonResponse.getJSONArray("choices");
                if (choices.length() > 0) {
                    JSONObject choice = choices.getJSONObject(0);
                    JSONObject message = choice.getJSONObject("message");
                    return message.getString("content");
                }
                
                return "AI分析失败，请重试";
                
            } catch (Exception e) {
                return "AI分析出错: " + e.getMessage();
            }
        }
        
        @Override
        protected void onPostExecute(String result) {
            askAIButton.setEnabled(true);
            askAIButton.setText("询问AI");
            
            // 显示AI分析结果
            String fullResult = currentPaiPan + "\n\n=== AI分析结果 ===\n" + result;
            resultText.setText(fullResult);
            
            Toast.makeText(MeiHuaYiShuActivity.this, "AI分析完成", Toast.LENGTH_SHORT).show();
        }
    }
}