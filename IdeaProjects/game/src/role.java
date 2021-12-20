public class role {
    int hp; //data member
    int att; //data member
    int mp; //data member
    String name; //data member

    role(String rolename,int rolehp,int roleatt,int rolemp){
        name=rolename;
        hp=rolehp;
        att=roleatt;
        mp=rolemp;
    }
    void getCurrentStatus(){
        System.out.println("NAME:" + name);
        System.out.println("HP:" + hp);
        System.out.println("ATT:" + att);
        System.out.println("MP:" + mp);
        System.out.println("--------------------");
    }
}
