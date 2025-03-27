#include <WiFi.h> 
#include <FirebaseESP32.h> //"Firebase ESP32 Client" by Mobizt
#include <ArduinoJson.h> //"ArduinoJson" by Benoit Blanchon

// Configurações do WiFi
// #define WIFI_SSID ""
// #define WIFI_PASSWORD ""

// Configurações do Firebase
#define FIREBASE_HOST "https://api-iot-microcontroller-default-rtdb.firebaseio.com/"
#define FIREBASE_AUTH "hGvYcR7SetlW3XrKP6vmgNVsjvwQRTWsmuiGgF0f"

// Objeto Firebase
FirebaseData firebaseData;

// #define SENSOR_PIN 34

void setup() {
  Serial.begin(115200);
  
  // Conecta ao WiFi
  WiFi.begin(WIFI_SSID, WIFI_PASSWORD);
  Serial.print("Conectando ao WiFi");
  while (WiFi.status() != WL_CONNECTED) {
    Serial.print(".");
    delay(300);
  }
  Serial.println();
  Serial.print("Conectado com IP: ");
  Serial.println(WiFi.localIP());
  
  // Inicializa o Firebase
  Firebase.begin(FIREBASE_HOST, FIREBASE_AUTH);
  Firebase.reconnectWiFi(true);
  
  // Configura o tamanho do buffer WiFi e de reconexão
  Firebase.setWriteSizeLimit(firebaseData, "tiny");
}

void loop() {
  // Lê o valor do sensor
  // int sensorValue = analogRead(SENSOR_PIN);
  
  // Cria um objeto JSON para enviar
  // FirebaseJson json;
  // json.set("valor", sensorValue);
  // json.set("timestamp", millis());
  
  // Envia os dados para o Firebase
  // if (Firebase.pushJSON(firebaseData, "/dados_sensor", json)) {
  //   Serial.println("Dados enviados com sucesso!");
  //   Serial.print("Caminho: ");
  //   Serial.println(firebaseData.dataPath());
  // } else {
  //   Serial.println("Falha no envio");
  //   Serial.print("Motivo: ");
  //   Serial.println(firebaseData.errorReason());
  // }
  
  // delay(5000); // Espera 5 segundos entre leituras
}
