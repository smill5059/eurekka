import React, { useEffect, useRef, useState } from 'react';
import axios from 'axios';
import { StyleSheet, SafeAreaView, FlatList, Text, View } from 'react-native';
import { theme } from '../common/theme';
import AsyncStorage from '@react-native-async-storage/async-storage';
import RecipeList, { Separator } from '../components/Recipe/RecipeList';
const RecipeListScreen = ({ navigation }) => {
  type recipe = {
    seq: string;
    section: string;
    title: string;
    parts: string;
    eng: string;
    car: string;
    pro: string;
    fat: string;
    nat: string;
    img: string;
    percentage: number;
    part01: string;
    part02: string;
    part03: string;
    part04: string;
    part05: string;
    part06: string;
    part07: string;
    part08: string;
    part09: string;
    part10: string;
    part11: string;
    part12: string;
    part13: string;
    part14: string;
    part15: string;
    part16: string;
    part17: string;
    part18: string;
    part19: string;
    part20: string;
    part21: string;
    part22: string;
    part23: string;
    part24: string;
    part25: string;
    part26: string;
    part27: string;
    part28: string;
    part29: string;
    part30: string;
    manual01: string;
    manual02: string;
    manual03: string;
    manual04: string;
    manual05: string;
    manual06: string;
    manual07: string;
    manual08: string;
    manual09: string;
    manual10: string;
    manual11: string;
    manual12: string;
    manual13: string;
    manual14: string;
    manual15: string;
  };

  const [recipes, setResult] = useState<Array<recipe>>([]);

  const [refrigerId, setRefId] = useState<String>('');
  AsyncStorage.getItem('userInfo', (err, res) => {
    const user = JSON.parse(res);
    setRefId(user.refrigeratorId);
  });

  const getRecipes = async () => {
    axios
      .get(`http://eurekka.kr:8000/recipe/${refrigerId}`)
      .then(({ data }) => {
        // const obj = JSON.parse(data);
        var a = JSON.stringify(data);
        var b = JSON.parse(a);
        // console.log(b['0']);
        var temp = [];
        for (var i = 0; i < 20; i++) {
          temp[i] = b[String(i)];
        }
        setResult(temp);
      })
      .catch((e) => {
        // API 호출이 실패한 경우
        console.error(e); // 에러표시
      });
  };

  let flatListRef = useRef(null);
  const toTop = () => {
    if (flatListRef.current == null) return;
    flatListRef.current.scrollToOffset({ animated: true, offset: 0 });
  };
  useEffect(() => {
    if (refrigerId.length != 0) getRecipes();
  }, [refrigerId]);
  useEffect(() => {
    const reload = navigation.addListener('focus', () => {
      if (refrigerId.length != 0) {
        getRecipes();
        toTop();
      }
    });
    return reload;
  }, [navigation, refrigerId]);

  return (
    <SafeAreaView style={styles.container}>
      <View style={styles.listItem}>
        <View style={styles.listHead}>
          <Text style={styles.title}>레시피</Text>
        </View>
        <FlatList
          ref={(ref) => {
            flatListRef.current = ref;
          }}
          data={recipes}
          keyExtractor={(item) => item.seq.toString()}
          renderItem={({ item }) => (
            <RecipeList
              {...item}
              onRecipePress={() =>
                navigation.navigate('RecipeDetail', {
                  recipe: item,
                })
              }
            />
          )}
          ItemSeparatorComponent={() => <Separator />}
          style={styles.list}
        />
      </View>
    </SafeAreaView>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: theme.background,
  },
  title: {
    fontSize: 20,
    color: '#F0F0FA',
  },
  listHead: {
    width: 370,
    height: 50,
    backgroundColor: '#95A0C0',
    borderTopLeftRadius: 25,
    borderTopRightRadius: 25,
    justifyContent: 'center',
    alignItems: 'center',
  },
  listItem: {
    marginTop: 20,
    marginBottom: 45,
    alignItems: 'center',
  },
  list: {
    width: 370,
  },
});
export default RecipeListScreen;
