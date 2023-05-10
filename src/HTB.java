//ignore duplicates
//integers

public class HTB {
    //p = množitelj
    //m = velikost tabele
    //c1 = konstanta 1
    //c2 = konstanta 2

    Integer[] table;
    int p;
    int m;
    int c1;
    int c2;



    //uporaba funkcije h'(k, i) = (h(k) + c1 * i + c2 * i2) mod m
    //Ko je to potrebno (i == m), razširimo tabelo na novo velikost: m ← 2 * m + 1
    HTB(int p, int m, int c1, int c2) {
        this.p = p;
        this.m = m;
        this.c1 = c1;
        this.c2 = c2;
        table = new Integer[m];
    }

    //insert
    //h(k) = k mod p
    //h'(k, i) = (h(k) + c1 * i + c2 * i2) mod m
    //Ko je to potrebno (i == m), razširimo tabelo na novo velikost: m ← 2 * m + 1
    void insert(int k){
        int i = 0;
        int h = k % p;
        int h1 = (h + c1 * i + c2 * i * i) % m;

        while (table[h1] != null) {
            i++;
            h1 = (h + c1 * i + c2 * i * i) % m;
        }

        table[h1] = k;

        if (i == m) {
            expand();
        }
    }

    String find(int k){
        int i = 0;
        int h = k % p;
        int h1 = (h + c1 * i + c2 * i * i) % m;

        while (table[h1] != null && table[h1] != k) {
            i++;
            h1 = (h + c1 * i + c2 * i * i) % m;
        }

        if (table[h1] == null) {
            // System.out.println("true");
            return "true";
        } else {
            // System.out.println("false");
            return "false";
        }
    }

    void delete(int k){
        int i = 0;
        int h = k % p;
        int h1 = (h + c1 * i + c2 * i * i) % m;

        while (table[h1] != null && table[h1] != k) {
            i++;
            h1 = (h + c1 * i + c2 * i * i) % m;
        }

        if (table[h1] != null) {
            table[h1] = null;
        }
    }

    //expand the table m ← 2 * m + 1
    void expand() {
        m = 2 * m + 1;


        Integer[] temp = table.clone();
        
        table = new Integer[m];

        for (int i = 0; i < temp.length; i++) {
            if (temp[i] != null) {
                insert(temp[i]);
            }
        }
        
        // table = new int[m];
    }

    //print key value pairs
    void printKeys(){
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                System.out.println(i + ": " + table[i]);
            }
        }
    }
}
