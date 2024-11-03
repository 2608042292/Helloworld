import java.util.Scanner;
abstract class ADetect {
    public abstract boolean detect(double sample);
} class TPDetect extends ADetect{  final double MINTP=36.0;
    //正常体温下限
    final double MAXTP=37.5; //正常体温上限
    public boolean detect(double tp){
        boolean r=false;
        if(tp> MAXTP){
            r=false;
        }else if (tp<MINTP){
            r=false;
        }else
            r = true;
        return r;
    }
}

public class adetect {
    public static void main(String[] args) {
        TPDetect tpd = new TPDetect();
        Scanner in=new  Scanner(System.in);
        System.out.print("请输入体温:");
        double temp=in.nextDouble();
        boolean b = tpd.detect(temp);
        if (b==true)
            System.out.print("体温正常");
        else
            System.out.print("体温异常");
    } }