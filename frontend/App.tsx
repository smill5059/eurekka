import { StatusBar } from 'expo-status-bar';
import React from 'react';
import { Button, View, Text } from 'react-native';
import { NavigationContainer } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack';
import LoginScreen from './src/screens/LoginScreen';
import HomeScreen from './src/screens/HomeScreen';

const Stack = createStackNavigator();

export default function App() {
  return (
    <NavigationContainer>
      <Stack.Navigator initialRouteName="Login">
        <Stack.Screen
          name="Login"
          component={LoginScreen}
          options={{ title: 'PROJECT LIST' }}
        />
        <Stack.Screen
          name="Home"
          component={HomeScreen}
          options={{ title: 'GAGURI' }}
        />
      </Stack.Navigator>
    </NavigationContainer>
  );
}
