class Solution {
    public int romanToInt(String s) {
        int result = 0;
        for(int i = 0;i<s.length();i++){
            switch(s.charAt(i)){
                case 'I':
                    if(i==s.length()-1){
                        result += 1;
                    }
                    else{
                        char c = s.charAt(i+1);
                        if(c == 'V'){ result += 4;i+=1; }
                        else if(c == 'X'){ result += 9; i+=1;}
                        else result+=1;
                    }
                    continue;
                case 'V':
                    result+=5;
                    continue;
                case 'X':
                    if(i==s.length()-1){
                        result += 10;
                    }
                    else{
                        char c = s.charAt(i+1);
                        if(c == 'L'){ result += 40;i+=1; }
                        else if(c == 'C'){ result += 90; i+=1;}
                        else result+=10;
                    }
                    continue;
                case 'L':
                    result+=50;
                    continue;
                case 'C':
                    if(i==s.length()-1){
                        result += 100;
                    }
                    else{
                        char c = s.charAt(i+1);
                        if(c == 'D'){ result += 400;i+=1; }
                        else if(c == 'M'){ result += 900; i+=1;}
                        else result+=100;
                    }
                    continue;
                case 'D':
                    result+=500;
                    continue;
                case 'M':
                    result+=1000;
                    continue;
            }
        }
        return result;
    }
}
