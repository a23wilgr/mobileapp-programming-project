public class Svamp {
    private String ID;
    private String name;
    private String location;
    private String category;
    private int size;

    public Svamp(String inName, String inLocation, String inCategory, int inSize){
        name=inName;
        location=inLocation;
        category=inCategory;
        size=inSize;
    }

    public String toString(){
        return name;
    }

    public String info(){
        String str=name;
        str+=" can be found in or near ";
        str+=location;
        str+=". it is ";
        str+=Integer.toString(size);
        str+="cm tall.";
        str+=" Belongs to the speciesfamily ";
        str+=category;
        return str;
    }
}
