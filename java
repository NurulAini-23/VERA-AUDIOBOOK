import { initializeApp } from "firebase/app";

const firebaseConfig = {
  apiKey: "YOUR_FIREBASE_API_KEY",
  authDomain: "YOUR_PROJECT.firebaseapp.com",
  projectId: "YOUR_PROJECT_ID",
  storageBucket: "YOUR_PROJECT.appspot.com",
  messagingSenderId: "YOUR_SENDER_ID",
  appId: "YOUR_APP_ID"
};

export const app = initializeApp(firebaseConfig);
export const generateAudio = async (text, lang = "en") => {
  const res = await fetch("https://texttospeech.googleapis.com/v1/text:synthesize?key=YOUR_GOOGLE_CLOUD_TTS_API_KEY", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({
      input: { text },
      voice: { languageCode: lang, ssmlGender: "NEUTRAL" },
      audioConfig: { audioEncoding: "MP3" }
    })
  });
  return await res.json();
};
