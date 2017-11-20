package ru.geekbrains.java2.dz.dz1.EmelyanovSergey;

public class Team implements Teamable  {

    //Вложенный класс "участник команды" - имя, сила, прошел полосу, какие барьеры прошел
    private class Member {
        private String name;
        private int power;
        private boolean courcePassed;


        public Member(String name, int power) {
            this.name = name;
            this.power = power;
        }

        public void getMemberInfo(){
            System.out.println("Участник:"+name+"; Сила:"+power);
        }

        public boolean tryPassBarriers(BarriersENum[] barriers){
            int myPower=this.power;
            for (BarriersENum b : barriers) {
                myPower-=b.getPowerToPass();
                //if (myPower>=0) {
                //    System.out.println("Участник " + this.name + " проходит препятствие " + b.getInfo());
                //}
            }
            this.courcePassed=(myPower>=0);//силы остались - значит может пройти
            return courcePassed;
        }
    }

    private Member[] members = new Member[4];
    private String teamName;

    public Team(String _teamName) {
        teamName=_teamName;
        members[0]=new Member("Василий",150);
        members[1]=new Member("Иван",130);
        members[2]=new Member("Геннадий",75);
        members[3]=new Member("Зинаида",30);
    }


    public void goToCource(Courseable c) {
        System.out.println("Команда "+this.teamName+" вышла на полосу: "+c.getInfo());
        for (int i = 0; i < members.length; i++) {
            members[i].tryPassBarriers(c.barriers);
        }
    }



    public void teamInfo() {
        System.out.println("Информация о команде");
        for (Member m : members) {
            System.out.println("Участник:"+m.name+" Сила="+m.power);
        }
    }

    public void teamResult() {
        System.out.println("Прохождение полосы");
        for (Member m : members) {
            System.out.println("Участник:"+m.name+"(Сила:"+m.power+") прошел:"+((m.courcePassed)?"ДА":"НЕТ"));
        }
    }

    public String getTeamName() {
        return teamName;
    }
}
