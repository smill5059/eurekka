import React, { useState } from 'react';
import { Button, View, Text, StyleSheet } from 'react-native';
import * as AuthSession from 'expo-auth-session';
import axios from 'axios';

function LoginScreen({ navigation }) {
  const [NV_APP_ID, setId] = useState<string>();
  const [NV_APP_SECRET, setSecret] = useState<string>();
  const [STATE_STRING, setState] = useState<string>();

  const [token, setToken] = useState<string>();
  const [code, setCode] = useState<string>();
  const [user, setUser] = useState<Object>();

  async function getNaverInfo() {
    const Info: {
      NV_APP_ID: string;
      NV_APP_SECRET: string;
      STATE_STRING: string;
    } = await axios.get(`http://localhost:8080/user/naver/state`);

    setId(Info.NV_APP_ID);
    setSecret(Info.NV_APP_SECRET);
    setState(Info.STATE_STRING);
  }

  async function handlePressAsync() {
    getNaverInfo();

    let redirectUrl = AuthSession.getRedirectUrl();
    console.log(redirectUrl);
    console.log(encodeURIComponent(redirectUrl));
    const result = await AuthSession.startAsync({
      authUrl: `https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=${NV_APP_ID}&redirect_uri=${encodeURIComponent(
        redirectUrl
      )}&state=${STATE_STRING}`,
    });
    console.log('result', result);
    if (result.type === 'success') setCode(result.params.code);
    handleGetAccess();
  }

  async function handleGetAccess() {
    const accessToken: { access_token } = await axios.get(
      `https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&client_id=${NV_APP_ID} &client_secret=${NV_APP_SECRET} &code=${code}&state=${STATE_STRING}`
    );

    const config = {
      headers: {
        Authorization: `Bearer ${accessToken.access_token}`,
      },
    };

    setToken(accessToken.access_token);

    const { data } = await axios.get(
      'https://openapi.naver.com/v1/nid/me',
      config
    );
    console.log(data);
    setUser(data);
  }

  const styles = StyleSheet.create({
    container: {
      flex: 1,
      backgroundColor: '#fff',
      alignItems: 'center',
      justifyContent: 'center',
    },
  });

  return (
    <View style={styles.container}>
      <Button title="goToHome" onPress={() => navigation.navigate('Home')} />
      <Text>네이버 아이디로 시작하기</Text>
      <Button title="Login" onPress={handlePressAsync} />
    </View>
  );
}

export default LoginScreen;
