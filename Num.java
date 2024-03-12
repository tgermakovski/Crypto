import java.util.ArrayList;

public class Num {

    ArrayList<Integer> numlist;

    Num(ArrayList<Integer> numlist){

        this.numlist = numlist;

    }

    public ArrayList<Integer> add(ArrayList<Integer> list2){

        ArrayList<Integer> sumlist = new ArrayList<>();
        for(int i=0;i<=numlist.size();i++) {sumlist.add(0);}


        for(int i=0; i<numlist.size(); i++)
        {
            int already_one = 0; if(sumlist.get(i)==1){already_one++;}

            int sum = numlist.get(i) + list2.get(i);

            sumlist.set(i,(sum + already_one)%10);

            if(sum + already_one >9){sumlist.set(i+1,1);}
        }

        System.out.print(sumlist);
        return sumlist;

    }

    public ArrayList<Integer> add(ArrayList<Integer> list1, ArrayList<Integer> list2){

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

    public ArrayList<Integer> mult(ArrayList<Integer> list2){

        ArrayList<Integer> metaprodlist = new ArrayList<>(); //meta product list
        for(int i=0;i<numlist.size()+list2.size();i++) {metaprodlist.add(0);}


        for(int i=0; i<numlist.size(); i++)
        {

            ArrayList<Integer> prodlist = new ArrayList<>(); //product list
            for(int j=0;j<numlist.size()+list2.size();j++) {prodlist.add(0);}

            for(int j=0;j<list2.size();j++)
            {

                int already = prodlist.get(i+j);

                int prod = numlist.get(i) * list2.get(j);

                prodlist.set(i+j,(already+prod)%10);

                if(prod+already > 9){ prodlist.set(i+j+1,(prod+already)/10); }

            }

            metaprodlist = add(metaprodlist, prodlist);

        }

        System.out.print("   meta: "+metaprodlist);
        return metaprodlist;

    }

    public ArrayList<Integer> mult(ArrayList<Integer> list1, ArrayList<Integer> list2){

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



    public ArrayList<Integer> exp(ArrayList<Integer> base, int exponent){

        if(exponent==0) {ArrayList<Integer> r = new ArrayList<>(); r.add(1); return r;}

        ArrayList<Integer> rr = base;

        for(int i=1; i<exponent; i++)
        {
            rr = mult(rr,base);
        }

        System.out.print("\n  x^y = "+rr);
        return rr;

    }


    /*
    *  2   8   0   0
    *  6   4   3   0
    *  0   8   6   7   2   0   0   0
    *
    *  4*2 6*2 3*2  + i=0
    *
    *      4*8 6*8 3*8  +  i=1
    *
    *
    *
    *
    *
    *
    *
    *
    *
    * */




}
