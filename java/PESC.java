
/**
 * Java Generic PECS - Producer Extends Consumer Super
 * 
 * <p>
 * - <? extends T> : Upper Bounds Wildcards 
 * - <? super T> : Lower Bounds Wildcards
 * </P>
 * 
 * @author liwenwei
 *
 */

//Lev 1
class Food{}

//Lev 2
class Fruit extends Food{}
class Meat extends Food{}

//Lev 3
class Apple extends Fruit{}
class Banana extends Fruit{}
class Pork extends Meat{}
class Beef extends Meat{}

//Lev 4
class RedApple extends Apple{}
class GreenApple extends Apple{}

class Plate<T>{
    private T item;
    public Plate(T t){item=t;}
    public void set(T t){item=t;}
    public T get(){return item;}
}

public class PESC {
	public static void main(String[] args) {
		/*
		 * Plate<Fruit> p = new Plate<Apple>(new Apple());
		 * error: incompatible types: Plate<Apple> cannot be converted to Plate<Fruit>
		 * 编译器逻辑：
		 *  - Apple is a Fruit
		 *  - Plate with Apple is not a Plate with Fruit
		 * 所以，就算容器里装的东西之间有继承关系，但容器之间是没有继承关系的。所以我们不可以把Plate的引用传递给Plate
		 */
		
		Plate<? extends Fruit> p=new Plate<Apple>(new Apple());
		
		/*
		//不能存入任何元素
		p.set(new Fruit());    //Error
		p.set(new Apple());    //Error
		*/

		//读取出来的东西只能存放在Fruit或它的基类里。
		Fruit newFruit1=p.get();
		Object newFruit2=p.get();
		// Apple newFruit3=p.get();    //Error
		
		
		Plate<? super Fruit> p_lower=new Plate<Fruit>(new Fruit());

		//存入元素正常
		p_lower.set(new Fruit());
		p_lower.set(new Apple());

		/*
		//读取出来的东西只能存放在Object类里。
		Apple newFruit3=p_lower.get();    //Error
		Fruit newFruit1=p_lower.get();    //Error
		*/
		Object newFruit3=p_lower.get();
	}

}
