import java.lang.Math;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        //aff();  //abcdefghijklmnopqrstuvwxyz  //3x+9 //4x+8
        //cyr();  //абвгдежзийклмнопрстуфхцчшщъыьэюя //5x+13 //5x+77
        //phi();    //2^3 3^5 5^7 0^0     (0^-1)*-1 = undefined
        //euc();
        //euc2();
        //sqm();   //explain how pick mod
        //sqm2(); //explain lists, credit to dad //123^100
        //rsa();  //getting over the hump //17 7 5 111   //pov bob
        //ferm();  //15 //72581989 //39982711 //63466343 //500339993
        //rsaFerm(); //119 5   //pov edgar
        //crt();
        //ssss(); //1,2 -3,4 7,5 ---
        //baby();  // 2 7 53



        //elg();
        //poli();

/*
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(2); al.add(8); al.add(3); al.add(3); al.add(8); al.add(5);al.add(7); al.add(4); al.add(1);
        ArrayList<Integer> la = new ArrayList<Integer>();
        la.add(6); la.add(4); la.add(3); la.add(1); la.add(3); la.add(8);la.add(6); la.add(2); la.add(8);
        mult(la,al);
*/
        //Num num = new Num(al);
        //num.mult(la);
        //num.exp(al,3);


    }

    //helper function
    static int inv(int x, int m)
    {
        for (int i = 1; i < m; i++){if (((x % m) * (i % m)) % m == 1){return i;}}
        return 1;
    }





    //      ********          ******        ********      //
    //   ****      *****    ***    ***   ****      ****   //
    //  **      *      *******      ******     *      **  //
    //   ***  ***     ***    ********   ***    ***  ***   //
    //     ****     ***         **        ***    ****     //





    //helper function
    public static boolean eachTerm(String a, String b, String c){

        c = c.substring(c.indexOf("=")+1);

        for(int i=0;i<c.length();i++)
        {
            if(c.substring(i,i+1).equals("+") || c.substring(i,i+1).equals("."))
            {
                if(!c.substring(0,i).contains(a) && !c.substring(0,i).contains(b))
                {return false;}else{c=c.substring(i+1);i=0;}
            }
        }
        return true;
    }

    //-------------------//
    //-------------------//
    //-------------------//
    //-------------------//


    public static void aff(){

        System.out.print("Affine Cypher Encryption and Decryption \n");
        Scanner scanner = new Scanner(System.in);
        int coe; int con;
        String inp = "";
        String out = "";
        String out2 = "";

        System.out.print("enter coefficient coprime to 26: ");
        coe = scanner.nextInt();
        System.out.print("enter constant: ");
        con = scanner.nextInt(); con=con%26;
        System.out.print("enter string; lowercase letters only: ");
        inp = scanner.nextLine(); inp = scanner.nextLine();

        while(!inp.equals("---")){

            for(int i=0;i<inp.length();i++)
            {
                char c = inp.charAt(i);
                int cc = (int) c;
                cc = cc - 97;
                cc = ((coe * cc) + con)%26;
                cc = cc + 97;
                c = (char) cc;
                String poop = String.valueOf(c);
                out = out + poop;

            }

            System.out.println("encrypted message: " + coe + "x +  " + con + " -> " + out);

            for(int i=0;i<out.length();i++){

                char c = out.charAt(i);
                int cc = (int) c;
                cc = cc - 97;
                cc = cc - con;
                if(cc<0){cc=cc+26;}
                cc = cc * inv(coe,26);
                cc = cc % 26;
                cc = cc + 97;
                c = (char) cc;
                String poop = String.valueOf(c);
                out2 = out2 + poop;

            }

            System.out.print("decrypted message: (x-" + con + ")/" + coe + " -> " + out2 + "\n");
            out = ""; out2 = ""; //clear
            System.out.print("enter string; lowercase letters only: ");
            inp = scanner.nextLine();

        }

        System.out.print("\n");
    }

    public static void cyr(){

        System.out.print("Cyrillic Affine Cypher Encryption and Decryption \n");
        Scanner scanner = new Scanner(System.in);
        int coe; int con;
        String inp = "";
        String out = "";
        String out2 = "";

        System.out.print("enter coefficient coprime to 32: ");
        coe = scanner.nextInt();
        System.out.print("enter constant: ");
        con = scanner.nextInt(); con=con%32;
        System.out.print("enter string; lowercase letters only: ");
        inp = scanner.nextLine(); inp = scanner.nextLine();

        while(!inp.equals("---")){

            for(int i=0;i<inp.length();i++)
            {
                char c = inp.charAt(i);
                int cc = (int) c;
                cc = cc - 1072;
                cc = ((coe * cc) + con)%32;
                cc = cc + 1072;
                c = (char) cc;
                String poop = String.valueOf(c);
                out = out + poop;

            }

            System.out.println("encrypted message: " + coe + "x +  " + con + " -> " + out);

            for(int i=0;i<out.length();i++){

                char c = out.charAt(i);
                int cc = (int) c;
                cc = cc - 1072;
                cc = cc - con;
                if(cc<0){cc=cc+32;}
                cc = cc * inv(coe,32);
                cc = cc % 32;
                cc = cc + 1072;
                c = (char) cc;
                String poop = String.valueOf(c);
                out2 = out2 + poop;

            }

            System.out.print("decrypted message: (x-" + con + ")/" + coe + " -> " + out2 + "\n");
            out = ""; out2 = ""; //clear
            System.out.print("enter string; lowercase letters only: ");
            inp = scanner.nextLine();

        }

        System.out.print("\n");
    }

    public static void phi(){

        System.out.print("Finding Phi(p0^a0 * p1^a1 * p2^a2 * ... * pk^ak) \n");

        Scanner scanner = new Scanner(System.in);
        String rep = "";
        int total = 1;
        int p=1;
        int a=1;
        int i = 0;

        while(p>0 || a>0)
        {
            System.out.print("enter p" + i + "^a" + i + ": ");
            String inp = scanner.nextLine();
            int icoma = inp.indexOf("^");
            p = Integer.valueOf(inp.substring(0,icoma));
            a = Integer.valueOf(inp.substring(icoma+1));
            if(p>0){rep = rep + p + "^" + a + " * ";}

            total = total * ((int)(Math.pow(p,a-1))*(p-1));
            i++;

        }
        rep = "Phi(" + rep + "yo mama) = " + total + " \n";
        System.out.print(rep);
        System.out.print("\n");

    }

    public static void euc(){

        System.out.print("Finding Greatest Common Divisor with Extended Euclidean Algorithm \n");

        Scanner scanner = new Scanner(System.in);
        System.out.print("enter x: ");
        int x = scanner.nextInt();
        System.out.print("enter y: ");
        int y = scanner.nextInt();
        int a = x; int b = y; int c; int d;
        ArrayList<String> eqs = new ArrayList<String>();

        if(x<y){a=y;b=x;}

        while(a%b>0)
        {
            c = a/b; d = a%b;
            System.out.print(" : " + a + " = " + b + "(" + c + ")" + " + " + d + "\n");
            eqs.add(d + "=" + a + "+-" + c + "*" + b + ".");
            a=b; b=d;
        }

        int gcd = b; //or d, same diff
        c = a/b; d = a%b;
        System.out.print(" : " + a + " = " + b + "(" + c + ")" + " + " + d + "\n");
        System.out.print("gcd(" + x + "," + y + ") = " + gcd + "\n");
        for(int i=0;i<eqs.size();i++)
        {
            System.out.println(" : "+eqs.get(i));
        }
        System.out.print("\n");



        String xstring = String.valueOf(x);
        String ystring = String.valueOf(y);
        eq(xstring,ystring,eqs,eqs.get(eqs.size()-1));

    }

    public static void eq(String nomber, String other_nomber, ArrayList<String> eqs, String x){

        /*String z = "49=163+-2*57.";
        String y = "8=57+-1*49.";
        String x = "1=49+-6*8.";
        ArrayList<String> eqs = new ArrayList<String>();
        eqs.add(x); eqs.add(y); eqs.add(z);*/

        //parse thru poly while not all terms contain 163 or 57
        while(!eachTerm(nomber,other_nomber,x)) {

            String xx = x.substring(x.indexOf("=") + 1);
            //System.out.print(x+"\n");

            //for all factors
            while (xx.length() > 1) {

                //System.out.println(xx);
                //System.out.println(x);

                int indexplus = xx.indexOf("+");
                if (indexplus == -1) {
                    indexplus = xx.length() - 1;
                }
                int indexstar = xx.indexOf("*");
                if (indexstar == -1) {
                    indexstar = xx.length() - 1;
                }
                int indexfirst = indexplus;
                if (indexplus > indexstar) {
                    indexfirst = indexstar;
                }

                String xxx = xx.substring(0, indexfirst);

                //check all other equations
                for (int i = 0; i < eqs.size(); i++) {
                    String eq = eqs.get(i);
                    if (eq.substring(0, eq.indexOf("=")).equals(xxx)) {
                        i = eqs.size();
                        //get right side of eq
                        String r = eq.substring(eq.indexOf("=") + 1, eq.indexOf("."));

                        //grab x.sub(xxx,next plus) = poop
                        //break r into a b c
                        // r = poop*a + poop*b + poop*c
                        //make sure to remove poop in original x


                        int nextplus = x.length() - 1;
                        for (int j = x.indexOf(xxx); j < x.length(); j++) {
                            if (x.substring(j, j + 1).equals("+")) {
                                nextplus = j;
                                j = x.length();
                            }
                        }
                        int prevplus = 0;
                        for (int j = x.indexOf(xxx); j > 0; j--) {
                            if (x.substring(j, j + 1).equals("+")) {
                                prevplus = j;
                                j = 0;
                            }
                        }

                        String poop = x.substring(x.indexOf(xxx) + xxx.length(), nextplus); //if xxx last factor of term
                        String oppo = "";
                        if (prevplus != 0) {
                            if (prevplus + 1 < x.indexOf(xxx)) {
                                oppo = x.substring(prevplus + 1, x.indexOf(xxx));
                                oppo = "*" + oppo.substring(0, oppo.length() - 1);
                            }
                        } else {
                            prevplus = x.indexOf("=");
                        }   //if first


                        for (int j = 0; j < r.length(); j++) {
                            if (r.substring(j, j + 1).equals("+")) {
                                r = r.substring(0, j) + poop + oppo + r.substring(j);
                                j = j + poop.length() + oppo.length();
                            }
                        }
                        r = r + poop + oppo;




                    /*
                    String temp = x.substring(x.indexOf(xxx)+xxx.length());
                    //loop thru temp until find + not *
                    for(int j=0;j>-1;j++){
                        if(temp.substring(j,j).equals("+")){i=-2;}
                    }*/

                        //find xxx's term


                        //swap all instances of xxx in x for r
                        while (x.contains(xxx)) {
                            x = x.substring(0, prevplus + 1) + r + x.substring(nextplus);
                            //x = x.substring(0,x.indexOf(xxx)) + r + x.substring(x.indexOf(xxx)+xxx.length());
                        }
                    }
                }

                //next factor
                xx = xx.substring(indexfirst + 1);


                //break into terms
                //for each terms, for each factor, if String factor=abc exists
                //term goes from <factor * poop * piss> to <poop*piss*a + poop*piss*b + poop*piss*c>
            }













            System.out.println(x);

        }




        //COMBINE LIKE TERMS BEFORE PRINTING

        String newx = x.substring(x.indexOf("=") + 1);
        int nombersum=0; int othernombersum=0;

        for(int i=0;i<newx.length();i++)
        {
            if(newx.substring(i,i+1).equals("+"))
            {
                String term = newx.substring(0,i); int termtotal=1;
                for(int j=0; j<term.length();j++)
                {
                    if(term.substring(j,j+1).equals("*"))
                    {
                        String factor = newx.substring(0,j);
                        if(!factor.equals(nomber) && !factor.equals(other_nomber)){
                            termtotal = termtotal * Integer.valueOf(factor);
                        }
                    }
                }
                if(term.contains(nomber)){nombersum=nombersum+termtotal;}else{othernombersum=othernombersum+termtotal;}
                newx = newx.substring(i+1); i=0;
            }
        }





        /*String newx = x.substring(x.indexOf("=") + 1);
        int nomber_total=0; int other_nomber_total=0;
        int nomber_prod=1; int other_nomber_prod=1;


        for(int i=0;i<newx.length();i++)
        {
            if(newx.substring(i,i+1).equals("+")){
                String temp = newx.substring(0,i)+"*";
                if(temp.contains(nomber))
                {
                    for(int j=0;j<temp.length();j++)
                    {
                        if(temp.substring(j,j+1).equals("*"))
                        {
                            int n = Integer.valueOf(temp.substring(0,j));
                            if(n!=Integer.valueOf(nomber)){nomber_prod = nomber_prod * n;}
                        }
                    }
                }
                else{
                    for(int j=0;j<temp.length();j++)
                    {
                        if(temp.substring(j,j+1).equals("*"))
                        {
                            int n = Integer.valueOf(temp.substring(0,j));
                            if(n!=Integer.valueOf(other_nomber)){other_nomber_prod = other_nomber_prod * n;}
                        }
                    }
                }
                newx = newx.substring(i+1); i=0;
            }
        }*/

    }



    public static void euc2(){

        System.out.print("Finding Greatest Common Divisor with Extended Euclidean Algorithm \n");

        Scanner scanner = new Scanner(System.in);
        System.out.print("enter x: ");
        int x = scanner.nextInt();
        System.out.print("enter y: ");
        int y = scanner.nextInt();
        int a = x; int b = y; int c; int d;
        if(x<y){a=y;b=x;}
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        ArrayList<Integer> list3 = new ArrayList<Integer>();
        list1.add(0); list1.add(0);
        list2.add(0); list2.add(1);
        list3.add(1); list3.add(0);

        while(a%b>0)
        {
            c = a/b; d = a%b;
            System.out.print(" : " + a + " = " + b + "(" + c + ")" + " + " + d + "\n");
            a=b; b=d; list1.add(c);
        }

        int gcd = b; //or d, same diff
        c = a/b; d = a%b; list1.add(c);
        System.out.print(" : " + a + " = " + b + "(" + c + ")" + " + " + d + "\n");
        System.out.print("gcd(" + x + "," + y + ") = " + gcd + "\n");
        System.out.print("\n");

        //refer to Introduction to Mathematical Cryptography by Hoffstein, Pipher, and Silverman, pages 18 and 19, to understand the following calculations

        if(true) { //gcd==1

            for (int i = 2; i < list1.size(); i++) {
                int entry2 = (list1.get(i) * list2.get(i - 1)) + list2.get(i - 2);              //top * left + 2 to the left
                list2.add(entry2);
                int entry3 = (list1.get(i) * list3.get(i - 1)) + list3.get(i - 2);              //top * left + 2 to the left
                list3.add(entry3);
            }

            System.out.print(list1 + "\n");
            System.out.print(list2 + "\n");
            System.out.print(list3 + "\n");

            int t = list1.size();
            String out = String.valueOf(gcd) + " = ";

            if (t % 2 == 0) {
                out = out + String.valueOf(list3.get(t - 2)) + "*" + String.valueOf(list2.get(t - 1) *gcd) + " - " + String.valueOf(list2.get(t - 2)) + "*" + String.valueOf(list3.get(t - 1) *gcd);
            } else {
                out = out + String.valueOf(list2.get(t - 2)) + "*" + String.valueOf(list3.get(t - 1) *gcd) + " - " + String.valueOf(list3.get(t - 2)) + "*" + String.valueOf(list2.get(t - 1) *gcd);
            }

            System.out.print(out);

        }else{} //call eq()

    }

    public static void sqm(){ //once actually compute x^k, int too small. must mod. how i choose mod.

        System.out.print("Illustrating Square and Multiply Algorithm \n");

        Scanner scanner = new Scanner(System.in);
        System.out.print("enter base: ");
        int b = scanner.nextInt();
        int mod = (int) Math.sqrt(2147483646 / b);
        System.out.print("enter exponent (exponent under 10000 for optimal visual representation): ");
        int x = scanner.nextInt();
        int xx = x;
        int i = 0;
        int y = 0;
        int bx = (int)Math.pow(b,y);
        String bxs = ":";
        String bbxxss = ":";
        String exp = "0";
        String bin = " ";
        String s = " ";
        String q = " ";
        String m = " ";

        do {
            xx = xx >>> 1; i++;
        }while(xx>1);
        //i is now index of leftmost 1

        //for each bit from i to 0
        for(int ind = i; ind>-1;ind--)
        {
            double mask = Math.pow(2,ind); int maska = (int)mask;
            if((x & maska) == 0) //sq
            {
                y = y * 2;
                int tempbx = bx;
                bx = (bx * bx)%mod;
                bxs = bxs + " " + b + "^" + y + " = " + bx + " mod " + mod + " :";
                bbxxss = bbxxss + " " + tempbx + "^2 = " + bx + " mod " + mod + " :";
                exp = exp + " " + y;
                bin = bin + "0 ";
                if(y>9){bin = bin + " ";} if(y>99){bin = bin + " ";} if(y>999){bin = bin + " ";}
                s = s + "s "; q = q + "q "; m = m + "  ";
                if(y>9){s=s+" ";q=q+" ";m=m+ " ";} if(y>99){s=s+" ";q=q+" ";m=m+" ";} if(y>999){s=s+" ";q=q+" ";m=m+" ";}
            }
            else { //sqm
                y = 1 + (y * 2);
                int tempbx = bx;
                bx = (bx * bx * b)%mod;
                bxs = bxs + " " + b + "^" + y + " = " + bx + " mod " + mod + " :";
                bbxxss = bbxxss + " " + tempbx + "^2 * "+b+" = " + bx + " mod " + mod + " :";
                exp = exp + " " + y;
                bin = bin + "1 ";
                if(y>9){bin = bin + " ";} if(y>99){bin = bin + " ";} if(y>999){bin = bin + " ";}
                s = s + "s "; q = q + "q "; m = m + "m ";
                if(y>9){s=s+" ";q=q+" ";m=m+ " ";} if(y>99){s=s+" ";q=q+" ";m=m+" ";} if(y>999){s=s+" ";q=q+" ";m=m+" ";}
            }
        }

        System.out.print(exp + "\n" + bin + "\n" + s + "\n" + q + "\n" + m + "\n");
        System.out.print(bxs + "\n");
        System.out.print(bbxxss);
        System.out.print("\n");
    }



    public static void sqm2(){ //once actually compute x^k, int too small. must mod. how i choose mod.

        System.out.print("Illustrating Square and Multiply Algorithm \n");

        Scanner scanner = new Scanner(System.in);
        System.out.print("enter base: ");
        int b = scanner.nextInt();

        ArrayList<Integer> blist = new ArrayList<>();
        String bstring = " " + Integer.toString(b);

        while(!bstring.equals(" "))
        {
            int numb = Integer.valueOf(bstring.substring(bstring.length() - 1));
            blist.add(numb);
            bstring = bstring.substring(0,bstring.length() - 1);
        }


        System.out.print("enter exponent (exponent under 10000 for optimal visual representation): ");
        int x = scanner.nextInt();
        int xx = x;
        int i = 0;
        int y = 0;

        ArrayList<Integer> bx = new ArrayList<>(); bx.add(1);

        do {
            xx = xx >>> 1; i++;
        }while(xx>1);
        //i is now index of leftmost 1

        //for each bit from i to 0
        for(int ind = i; ind>-1;ind--)
        {
            double mask = Math.pow(2,ind); int maska = (int)mask;
            if((x & maska) == 0) //sq
            {
                y = y * 2;
                ArrayList<Integer> tempbx = bx;
                bx = mult(bx, bx);

            }
            else { //sqm
                y = 1 + (y * 2);
                ArrayList<Integer> tempbx = bx;
                bx = mult(bx, bx); bx = mult(bx, blist);

            }
        }


        System.out.print("\n   " + b + "^" + x + "= ");
        for(int index = bx.size()-1; bx.get(index)==0 && index > -1; index--)
        {
            bx.remove(index);
        }

        for(int index = bx.size()-1;index > -1; index--){
            System.out.print(bx.get(index));
        }

        System.out.print("\n");
    }




    public static void rsa(){ //why does n+ break. why does n-1 not encrypt

        System.out.print("RSA Encryption and Decryption \n");

        Scanner scanner = new Scanner(System.in);
        System.out.print("enter Bob's p: ");
        int p = scanner.nextInt();
        System.out.print("enter Bob's q: ");
        int q = scanner.nextInt();
        int n = p*q;
        System.out.print("n = " + n + "\n");
        System.out.print("enter Bob's e: ");
        int e = scanner.nextInt();
        int d = inv(e,((p-1)*(q-1)));
        System.out.print("enter Alice's |x| < n: ");
        int x = scanner.nextInt();

        //int y = (int) Math.pow((double) x, (double) e);

        int ee = e/2;
        int y = x*x;

        for(int i=0;i<ee-1;i++)
        {y = (y*(x*x))%n;}

        //if odd
        if(e%2!=0)
        {
            y=y*x;
            y=y%n;
        }

        System.out.print("y: " + y + "\n");
        //int xx = (int) Math.pow((double)y,(double)d);
        //xx = xx%n;



        int dd = d/2;
        int xx = y*y;

        for(int i=0;i<dd-1;i++)
        {xx = (xx*(y*y))%n;}

        //if odd
        if(d%2!=0)
        {
            xx=xx*y;
            xx=xx%n;
        }



        System.out.print("x: " + xx + " \n");
        System.out.print("\n");

    }

    public static void rsaFerm(){ //why does n+ break. why does n-1 not encrypt

        System.out.print("RSA Encryption and Decryption using Fermat's Factorization \n");

        Scanner scanner = new Scanner(System.in);
        System.out.print("enter Bob's n: ");
        int n = scanner.nextInt();
        int p = ferm2(n); int q = n/p;
        System.out.print("n = " + n + " = " + p + " * " + q + "\n");

        System.out.print("enter Bob's e: ");
        int e = scanner.nextInt();
        int d = inv(e,((p-1)*(q-1)));
        System.out.print("enter Alice's |x| < n: ");
        int x = scanner.nextInt();

        //int y = (int) Math.pow((double) x, (double) e);

        int ee = e/2;
        int y = x*x;

        for(int i=0;i<ee-1;i++)
        {y = (y*(x*x))%n;}

        //if odd
        if(e%2!=0)
        {
            y=y*x;
            y=y%n;
        }

        System.out.print("y: " + y + "\n");
        //int xx = (int) Math.pow((double)y,(double)d);
        //xx = xx%n;



        int dd = d/2;
        int xx = y*y;

        for(int i=0;i<dd-1;i++)
        {xx = (xx*(y*y))%n;}

        //if odd
        if(d%2!=0)
        {
            xx=xx*y;
            xx=xx%n;
        }



        System.out.print("x: " + xx + " \n");
        System.out.print("\n");

    }







    public static void ferm(){

        System.out.print("Fermat's Factorization \n");

        Scanner scanner = new Scanner(System.in);
        System.out.print("enter n: ");
        int n = scanner.nextInt();
        double dtm = Math.sqrt(n);
        int itm = (int)dtm + 1;
        int s = 0; int t = 0;
        int p; int q;


        if(n%2==0){p=2; q=n/2;}
        else if(n%3==0){p=3; q=n/3;}
        else if(n%5==0){p=5; q=n/5;}
        else if(n%7==0){p=7; q=n/7;}
        else if(n%11==0){p=11; q=n/11;}
        else if(n%13==0){p=13; q=n/13;}
        else if(n%17==0){p=17; q=n/17;}
        else if(n%19==0){p=19; q=n/19;}
        else if(n%23==0){p=23; q=n/23;}
        else if(n%29==0){p=29; q=n/29;}
        else if(n%31==0){p=31; q=n/31;}
        else if(n%37==0){p=37; q=n/37;}
        else if(n%41==0){p=41; q=n/41;}
        else if(n%43==0){p=43; q=n/43;}
        else if(n%47==0){p=47; q=n/47;}
        else{
            for(int i=0;i>-1;i++){
                int tm = itm+i;
                double sm = Math.sqrt((Math.pow(tm,2)-n));
                System.out.print(i + " " + tm + " " + sm + "\n");
                if(sm == (int)sm){i=-2; s = (int)sm; t = (int)tm;}
            }
            p = t + s;
            q = t - s;
        }

        n = p*q;
        System.out.print("\np: " + p + " q:" + q + " n:" + n + "\n");
        System.out.print("\n");

    }


    public static int ferm2(int n){

        double dtm = Math.sqrt(n);
        int itm = (int)dtm + 1;
        int s = 0; int t = 0;
        int p; int q;


        if(n%2==0){p=2; q=n/2;}
        else if(n%3==0){p=3; q=n/3;}
        /*
        else if(n%5==0){p=5; q=n/5;}
        else if(n%7==0){p=7; q=n/7;}
        else if(n%11==0){p=11; q=n/11;}
        else if(n%13==0){p=13; q=n/13;}
        else if(n%17==0){p=17; q=n/17;}
        else if(n%19==0){p=19; q=n/19;}
        else if(n%23==0){p=23; q=n/23;}
        else if(n%29==0){p=29; q=n/29;}
        else if(n%31==0){p=31; q=n/31;}
        else if(n%37==0){p=37; q=n/37;}
        else if(n%41==0){p=41; q=n/41;}
        else if(n%43==0){p=43; q=n/43;}
        else if(n%47==0){p=47; q=n/47;} */
        else{
            for(int i=0;i>-1;i++){
                int tm = itm+i;
                double sm = Math.sqrt((Math.pow(tm,2)-n));
                System.out.print(i + " " + tm + " " + sm + "\n");
                if(sm == (int)sm){i=-2; s = (int)sm; t = (int)tm;}
            }
            p = t + s;
            q = t - s;
        }

        return p;

    }

    public static void crt()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Chinese Remainder Theorem: finding x congruent to a0%m0, a1%m1, a2%m2, ... ak%mk \n");

        ArrayList<Integer> alist = new ArrayList<Integer>();
        ArrayList<Integer> mlist = new ArrayList<Integer>();
        ArrayList<Integer> productlist = new ArrayList<Integer>();
        ArrayList<Integer> inverselist = new ArrayList<Integer>();
        int a=1;
        int m=0;
        int i = 0;

        while(a>0)
        {
            System.out.print("enter a" + i + "%m" + i + ": ");
            String inp = scanner.nextLine();
            int icoma = inp.indexOf("%");
            a = Integer.valueOf(inp.substring(0,icoma));
            m = Integer.valueOf(inp.substring(icoma+1));
            if(a>0){alist.add(a); mlist.add(m);}
            i++;
        }

        //x list
        for(i=0;i<mlist.size();i++)
        {
            int total = 1;
            for(int j=0;j<mlist.size();j++){
                if(j!=i){total=total*mlist.get(j);}
            }
            productlist.add(total);
        }

        //y list
        for(i=0;i<productlist.size();i++)
        {
            int joemama = productlist.get(i) % mlist.get(i);
            joemama = inv(joemama, mlist.get(i));
            joemama = joemama * alist.get(i) * productlist.get(i);
            inverselist.add(joemama);
        }

        int z = 0; String zz = "z = ";
        for(i=0;i<inverselist.size();i++)
        {
            z = z + inverselist.get(i);
            zz = zz + inverselist.get(i) + " + ";
        }
        zz = zz.substring(0,zz.length()-2) + " = " + z;


        m = 1; String mm = "m = ";
        for(i=0;i<mlist.size();i++)
        {
            m = m * mlist.get(i);
            mm = mm + mlist.get(i) + " * ";
        }
        mm = mm.substring(0,mm.length()-2) + " = " + m;


        for(i=0;i<alist.size();i++)
        {
            System.out.print("i:" + i + "   a:" + alist.get(i) + "   m:" + mlist.get(i) + "   product:" + productlist.get(i) + "   inverse:" + inverselist.get(i) + "\n");
        }
        System.out.print(zz + "\n"); System.out.print(mm + "\n");

        int x= z%m;
        System.out.print("x = z mod m = " + x + "\n");

    }


    public static void ssss()
    {



        System.out.print("Use LaGrange's Interplublooblablolulaplb Formula to Find Polynomial passing thru (a0,b0), (a1,b1), (a2,b2) ... (ak,bk)  \n");

        Scanner scanner = new Scanner(System.in);
        int a = 1; int b = 1; int i=0; boolean go = true;
        ArrayList<Integer> alist = new ArrayList<Integer>();
        ArrayList<Integer> blist = new ArrayList<Integer>();

        while(go)
        {
            System.out.print("enter a" + i + ",b" + i + ": ");
            String inp = scanner.nextLine();
            if(!inp.equals("---")) {
                int icoma = inp.indexOf(",");
                a = Integer.valueOf(inp.substring(0,icoma));
                b = Integer.valueOf(inp.substring(icoma+1));
                alist.add(a); blist.add(b);
                i++;
            }else{go = false;}
        }

        ArrayList<ArrayList<Integer>> plist = new ArrayList<>();

        for(i=0;i< alist.size();i++)
        {
            ArrayList<Integer> top = new ArrayList<>();
            int bottom = 1;

            for(int j=0;j<alist.size();j++)
            {
                if(i!=j)
                {
                    top.add(alist.get(j)); bottom = bottom * (alist.get(i) - alist.get(j));
                }
            }
            top.add(blist.get(i)); top.add(bottom); plist.add(top);

        }

        String pp = "P(x) = ";

        for(i=0;i<plist.size();i++)
        {
            //
            ArrayList<Integer> p = plist.get(i); pp = pp + "(" + p.get(p.size()-2) + "*";
            for(int j=0; j<p.size()-2; j++)
            {
                pp = pp + "(x-" + String.valueOf(p.get(j)) + ")*";
            }
            pp=pp.substring(0,pp.length()-2);
            pp = pp + "))/" + p.get(p.size()-1) + " + ";
            //
        }
        pp=pp.substring(0,pp.length()-3);
        System.out.print(pp+"\n");

        for(i=0;i<alist.size();i++)
        {
            String ppp = pp;
            for(int x=0;x<ppp.length();x++)
            {
                if(ppp.charAt(x)=='x')
                {
                    ppp = ppp.substring(0,x) + String.valueOf(alist.get(i)) + ppp.substring(x+1);
                }
            }

            ArrayList<Integer> p = plist.get(i); int x = p.get(p.size()-2);
            for(int j=0;j<p.size()-2;j++)
            {
                x = x * (alist.get(i) - p.get(j));
            }
            x = x / p.get(p.size()-1);
            System.out.print(ppp + " = " + x+"\n");
        }






        /*

        String px = "P(x) = ";

        for(i=0;i<plist.size();i++)
        {
            ArrayList<Integer> p = plist.get(i);
            px = px + "((" + p.get(p.size()-1) + " * ";

            for(int j=0;j<p.size()-2;j++)
            {
                px = px + "(x - " + p.get(j) + ")";
            }

            px = px + ") / " + p.get(p.size()-2) + ") + ";

        }
        px = px.substring(0,px.length()-3);
        System.out.print(px + "\n");


        px = "P(" + String.valueOf(alist.get(0)) + ") = "; int pxval = 1;
        for(i=0;i<alist.size();i++)
        {
            ArrayList<Integer> p = plist.get(i);
            px = px + "((" + p.get(p.size()-1) + " * "; pxval = pxval * p.get(p.size()-1);

            for(int j=0;j<p.size()-2;j++)
            {
                px = px + "(" + String.valueOf(alist.get(i)) +  " - " + p.get(j) + ")";
                pxval = pxval * (alist.get(i) - p.get(j));
            }

            px = px + ") / " + p.get(p.size()-2) + ") + ";  pxval = pxval / p.get(p.size()-2);

        }
        px = px.substring(0,px.length()-3);
        px = px + " = " + pxval;
        System.out.print(px + "\n");




        */

        System.out.print("\n");



    }


    public static void baby()
    {
        System.out.print("Shanks Baby Steps Giant Steps Algorithm: a^x = g mod p, solve for x \n");
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter a: ");
        int a = scanner.nextInt();
        System.out.print("enter g: ");
        int g = scanner.nextInt();
        System.out.print("enter p: ");
        int p = scanner.nextInt();

        int b = 1; int counter = 0;
        do
        {
            b = (b*a)%p;
            counter++;

        }while(b!=1);

        int N = counter-1;
        int m = (int) Math.sqrt(N) + 1;

        ArrayList<Integer> L1 = new ArrayList<>();
        for(int i=0;i<m;i++)
        {
            int x = 1;

            for(int j=0;j<m*i;j++)
            {
                x = (x * a)%p;
            }

            L1.add(x);
        }
        System.out.print("L1: " + L1 + "\n");

        ArrayList<Integer> L2 = new ArrayList<>();
        for(int i=0;i<m;i++)
        {
            int x = 1;

            for(int j=0;j<i;j++)
            {
                x = (x * a)%p;
            }

            x = (g*inv(x,p))%p;

            L2.add(x);
        }
        System.out.print("L2: " + L2 + "\n");

        int L1index=0; int L2index=0;

        for(int i=0;i<L1.size();i++)
        {
            for(int j=0;j<L2.size();j++)
            {
                if(L1.get(i)==L2.get(j)){
                    L1index = i;
                    L2index = j;
                }
            }
        }
        int x =  (m*L1index + L2index) % p;
        System.out.print(a + "^" + x + " mod " + p + " = " + g + "\n");








    }

    public static void polhel() //ne poniaw
    {
        System.out.print("Polig Hellman: a^x = g mod p, solve for x \n");
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter a: ");
        int a = scanner.nextInt();
        System.out.print("enter g: ");
        int g = scanner.nextInt();
        System.out.print("enter p: ");
        int p = scanner.nextInt();

        int b = 1; int counter = 0;
        do
        {
            b = (b*a)%p;
            counter++;

        }while(b!=1);

        int N = counter-1;
        System.out.print(N);
        int m = (int) Math.sqrt(N) + 1;
    }

    public static void elg()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter p: ");
        int p = scanner.nextInt();
        System.out.print("enter g: ");
        int g = scanner.nextInt();

        System.out.print("Team Red, enter message < p: ");
        int m = scanner.nextInt();
        System.out.print("Team Red, choose secret key a: ");
        int a = scanner.nextInt();
        int A = (int) Math.pow(g,a)%p;
        System.out.print("A = " + g + "^" + a + " mod p = " + A + "\n");

        System.out.print("Team Blue, enter message < p: ");
        int mm = scanner.nextInt();
        System.out.print("Team Blue, choose secret key b: ");
        int b = scanner.nextInt();
        int B = (int) Math.pow(g,b)%p;
        System.out.print("B = " + g + "^" + b + " mod p = " + B + "\n");

        System.out.print("Team Red, choose 2 < k < 296208088: \n");
        int k = scanner.nextInt();
        int c1 = (int) Math.pow(g,k) % p;
        int c2 = 1;
        for(int i=0;i<k;i++)
        {
            c2 = c2 * B;
            c2 = c2%p;
        }
        c2 = (c2 * m) % p;
        System.out.print(c1 + " " + c2 + "\n");

        System.out.print("Team Blue, choose 2 < k < 296208088: \n");
        int kk = scanner.nextInt();
        int d1 = (int) Math.pow(g,kk) % p;
        int d2 = 1;
        for(int i=0;i<kk;i++)
        {
            d2 = d2 * A; d2 = d2%p;
        }
        d2 = (d2 * mm) % p;
        System.out.print(d1 + " " + d2);







    }


    //credit to my dad, Sergey Germakovski, for giving me the idea to represent big numbers as Arraylists, which allows for the following add, mult, and exp methods.
    public static ArrayList<Integer> add(ArrayList<Integer> list1, ArrayList<Integer> list2){

        ArrayList<Integer> bigger = list1;
        ArrayList<Integer> lesser = list2;
        if(list1.size()<list2.size()){bigger = list2; lesser = list1;}

        ArrayList<Integer> sumlist = new ArrayList<>();
        for(int i=0;i<=bigger.size();i++) {sumlist.add(0);}


        for(int i=0; i<lesser.size(); i++)
        {
            int already_one = 0; if(sumlist.get(i)==1){already_one++;}

            int sum = list1.get(i) + list2.get(i);

            sumlist.set(i,(sum + already_one)%10);

            if(sum + already_one >9){sumlist.set(i+1,1);}
        }


        System.out.print(sumlist);
        return sumlist;

    }

    public static ArrayList<Integer> mult(ArrayList<Integer> list1, ArrayList<Integer> list2){

        ArrayList<Integer> metaprodlist = new ArrayList<>(); //meta product list
        for(int i=0;i<list1.size()+list2.size();i++) {metaprodlist.add(0);}


        for(int i=0; i<list1.size(); i++)
        {

            ArrayList<Integer> prodlist = new ArrayList<>(); //product list
            for(int j=0;j<list1.size()+list2.size();j++) {prodlist.add(0);}

            for(int j=0;j<list2.size();j++)
            {

                int already = prodlist.get(i+j);

                int prod = list1.get(i) * list2.get(j);

                prodlist.set(i+j,(already+prod)%10);

                if(prod+already > 9){ prodlist.set(i+j+1,(prod+already)/10); }

            }

            metaprodlist = add(metaprodlist, prodlist);

        }

        System.out.print("   meta: "+metaprodlist);
        return metaprodlist;

    }



    public static ArrayList<Integer> exp(ArrayList<Integer> base, int exponent){

        if(exponent==0) {ArrayList<Integer> r = new ArrayList<>(); r.add(1); return r;}

        ArrayList<Integer> rr = base;

        for(int i=1; i<exponent; i++)
        {
            rr = mult(rr,base);
        }

        System.out.print("\n  x^y = "+rr);
        return rr;

    }





}
