public class Cipher {
    private int offset;

    public Cipher(int offset){
       setOffset(offset);
    }

    public void setOffset(int offset){
        this.offset = offset;
    }

    public boolean checkAlphabet(char ch, char a, char z){
        return ch >= a && ch <= z;
    }

    public char getChar(char ch){
        char result;
        char a, z;

        if(Character.isUpperCase(ch)){
            a = 'A';
            z = 'Z';
        }
        else{
            a = 'a';
            z = 'z';
        }

        if(checkAlphabet(ch, a, z)){
            if(ch + offset > z){
                result = (char) (a + offset - (z - ch + 1));
            }
            else if(ch + offset < a){
                result = (char) (z + offset + (ch - a + 1));
            }
            else{
                result = (char) (ch + offset);
            }
        }
        else{
            result = ch;
        }

        return result;
    }

    public String encrypt(String s){
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray())
            sb.append(getChar(c));

        return sb.toString();
    }

    public String decrypt(String s){
        return new Cipher(-1 * offset).encrypt(s);
    }
}
