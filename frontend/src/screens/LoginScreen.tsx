import React from 'react';
import { Button, View, Text, StyleSheet, Linking } from 'react-native';
import axios from 'axios';

function LoginScreen({ navigation }) {
  async function handleClick() {
    const url = await axios.get(`http://localhost:8080/user/naver/url`);

    if (url.data != undefined) {
      Linking.canOpenURL(url.data).then((supported) => {
        if (supported) {
          Linking.openURL(url.data);
        } else {
          console.log("Don't know how to open URI: " + url);
        }
      });
    }
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
      <Button title="Login" onPress={handleClick} />
    </View>
  );
}

export default LoginScreen;
