import * as React from 'react';
import { Button, View, Text } from 'react-native';

function HomeScreen({ navigation }) {
    return (
        <View style={{ flex: 1, alignItems: 'center', justifyContent: 'center' }}>
        <Text>Details Screen</Text>
        <Button
            title="Go to Home... again"
            onPress={() => navigation.push('Home')}
        />
        <Button title="Go back" onPress={() => navigation.goBack()} />
        </View>
    );
}

export default HomeScreen;