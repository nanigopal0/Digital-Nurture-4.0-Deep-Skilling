import { createContext, useState } from 'react';

const theme = createContext();

function ThemeContext(){
    const [theme,setTheme] = useState('light');


}