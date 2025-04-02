#include <WiFi.h>
#include <FirebaseESP32.h>

// Configurações do WiFi
#define WIFI_SSID "Nicolas"
#define WIFI_PASSWORD "12345678"

// Configurações do Firebase
#define FIREBASE_HOST "https://api-iot-microcontroller-default-rtdb.firebaseio.com/"
#define FIREBASE_AUTH "hGvYcR7SetlW3XrKP6vmgNVsjvwQRTWsmuiGgF0f"

// Objeto Firebase
FirebaseData firebaseData;

void setup() {
  Serial.begin(115200);
  
  // Conectar ao WiFi
  WiFi.begin(WIFI_SSID, WIFI_PASSWORD);
  Serial.print("Conectando ao WiFi");
  while (WiFi.status() != WL_CONNECTED) {
    Serial.print(".");
    delay(300);
  }
  Serial.println();
  Serial.print("Conectado com IP: ");
  Serial.println(WiFi.localIP());
  
  // Inicializar Firebase
  Firebase.begin(FIREBASE_HOST, FIREBASE_AUTH);
  Firebase.reconnectWiFi(true);
  
  // Testar conexão com Firebase
  if (Firebase.setInt(firebaseData, "/testConnection", 123)) {
    Serial.println("Conexão com Firebase estabelecida com sucesso!");
  } else {
    Serial.println("Falha na conexão com Firebase");
    Serial.println("Motivo: " + firebaseData.errorReason());
  }
}

void loop() {
  // Ler o valor que acabamos de escrever
  if (Firebase.getInt(firebaseData, "/testConnection")) {
    Serial.print("Valor lido do Firebase: ");
    Serial.println(firebaseData.intData());
  } else {
    Serial.println("Falha ao ler do Firebase");
    Serial.println("Motivo: " + firebaseData.errorReason());
  }
  
  delay(5000);
}