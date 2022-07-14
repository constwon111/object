package ch4.Rectangle;

public class Rectangle {
    private int left;
    private int top;
    private int right;
    private int bottom;

    public Rectangle(int left, int top, int right, int bottom){
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }

    public int getLeft(){return left;}
    public void setLeft(int left){this.left = left;}

    public int getRight(){return right;}
    public void setRight(int right){this.right = right;}

    public int getTop(){return top;}
    public void setTop(int top){this.top = top;}

    public int getBottom(){return bottom;}
    public void setBottom(int bottom){this.bottom = bottom;}
// 이처럼 get함수, set함수를 여러개 놓음으로서 결과적으로 각각의 상태(left,top 등) 을 감췄다고
// 생각할 수 있지만(private이므로) 그렇지 않다.
// get함수를 통해서 클라이언트는 결국 left,top과 같은 상태들에 대해 유추할 수 있기 때문이다.
// 캡슐화가 잘 이루어져있다는건 내부 구현에서의 상태는 노출시키지 않고 단지, 인터페이스의 메세징으로
// 받은 결과값만 잘 전달해주면 되는 것이다.

    

    // ##### 책에서 알려준 해결 방법 ####
    // 이처럼 어떠한 행위는 해당 클래스에서 다 마치고(여기선 확장하는 행위),
    // 그 결과값만 넘겨주도록 한다. 이렇게 하면 굳이 get, set함수를 남발할 필요가 없다.
    public void enlarge(int multiple){
    right *= multiple;
    bottom *= multiple;
    }

}

class AnyClass{
    void anyMethod(Rectangle rectangle, int multiple){
        rectangle.setRight(rectangle.getRight()*multiple);
        rectangle.setBottom(rectangle.getBottom()*multiple);
    }
}
// 이와같이 Rectangle에서는 상태만 정의하고, set하는 행위를 다른 class에게 위임시킨다면 
// 결국 다른 클래스에서 Rectangle에 대한 정보를 알아야한다. 이는 의존성이 높은 코드이다.
// 좋은 방향으로 바꾸려면, 굳이 set함수를 저렇게 남발하는것이 아니라 모조리 감추고, 다만
// 어떤 메소드를 통해 굳이 위의 내용들을 알지 못해도 사각형을 만들 수 있게 해야한다.
