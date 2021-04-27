import * as React from 'react';
import { Button, View, Text } from 'react-native';

function LoginScreen({ navigation }) {
    return (
      <View style={{ flex: 1, alignItems: 'center', justifyContent: 'center' }}>
        <Text>Home Screen</Text>
        <Button
          title="Login"
          onPress={() => navigation.navigate('Home')}
        />
      </View>
    );
}
 
export default LoginScreen;
