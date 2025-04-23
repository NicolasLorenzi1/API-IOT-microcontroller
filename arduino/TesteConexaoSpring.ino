#include <WiFi.h>
#include <HTTPClient.h>

const char* ssid = "Nicolas";
const char* password = "12345678";
const char* serverUrl = "http://IPv4:8080/api/teste/sensor"; 

void setup() {
  Serial.begin(115200);
  WiFi.begin(ssid, password);
  
  while (WiFi.status() != WL_CONNECTED) {
    delay(1000);
    Serial.println("Conectando ao WiFi...");
  }
  Serial.println("Conectado ao WiFi");
  Serial.print("IP do ESP32: ");
  Serial.println(WiFi.localIP());
}

void loop() {
  if (WiFi.status() == WL_CONNECTED) {
    HTTPClient http;
    http.begin(serverUrl);
    http.addHeader("Content-Type", "application/json");
    http.addHeader("Connection", "close"); 

    int valorSensor = 10
    String payload = "{\"sensor\":\"TEMP\",\"valor\":" + String(valorSensor) + "}";

    Serial.println("Enviando: " + payload);
    
    int httpCode = http.POST(payload);
    
    if (httpCode == HTTP_CODE_OK) {
      Serial.println("Dados enviados com sucesso!");
      Serial.println("Resposta: " + http.getString());
    } else {
      Serial.print("Falha no envio. Código HTTP: ");
      Serial.println(httpCode);
      Serial.println("Erro: " + http.errorToString(httpCode));
    }
    
    http.end();
  } else {
    Serial.println("WiFi desconectado! Tentando reconectar...");
    WiFi.reconnect();
  }
  
  delay(10000); 
}