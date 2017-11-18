package ru.geekbrains.java2.dz.dz1.RoumyantsevPA; /**
 */
public class Dog extends Animal implements Swimable, Jumpable {

    public Dog(String name) {
        super(name);
      //  this.name = name;
        onDistance = true;
        animType = "Dog";
        maxRunDistance = 1000;
    }

    @Override
    public void swim(float dist) {
        if(dist < 300) {
            System.out.println(animType + " water ok");
        } else {
            getOutFromDistance("swim");
        }
    }

    @Override
    public void jump(float height) {
        if(height < 0.5f) {
            System.out.println(animType + " jump ok");
        } else {
            getOutFromDistance("jump");
        }
    }


}
