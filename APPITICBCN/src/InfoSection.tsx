import { Background } from '@react-navigation/elements';
import * as React from 'react';
import { ScrollView } from 'react-native';
import { List, useTheme } from 'react-native-paper';
import { useNavigation } from '@react-navigation/native';
import { StackNavigationProp } from '@react-navigation/stack';
import { RootStackParamList } from './RootStackParamList';

import itemsData from './data/itemsData.json';

const InfoSection = () => {
    const theme = useTheme();
    
    type NewsNavigationProp = StackNavigationProp<RootStackParamList, 'InfoSection'>

    const navigation = useNavigation<NewsNavigationProp>();

    return (
    <ScrollView>
        {itemsData.map((item) => (
        <List.Item
            key={item.id}
            title={item.title}
            left={(props) => <List.Icon {...props} icon={item.icon} />}
            style={{backgroundColor: theme.colors.onSecondary, margin:15, marginBottom:0, borderRadius:10}}
            onPress={() => navigation.navigate('InfoItem', {
            titulo: item.title,
            subtitulo: item.subtitle,
            texto: item.text,
            })}
        />
        ))}
    </ScrollView>
    );
}

export default InfoSection;
