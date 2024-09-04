import java.util.*;
import java.sql.*;
import java.lang.Thread;
public class j{
    static void fun(int a)
    {
        switch(a){
            case 1:
            System.out.printf("\t\t\t\t\t->blood group:A+              \n");
                break;
            case 2:
            System.out.printf("\t\t\t\t\t->blood group:O+              \n");
                break;
            case 3:
            System.out.printf("\t\t\t\t\t->blood group:B+              \n");
                break;
            case 4:
            System.out.printf("\t\t\t\t\t->blood group:AB+             \n");
                break;
            case 5:
            System.out.printf("\t\t\t\t\t->blood group:A-              \n");
                break;
            case 6:
            System.out.printf("\t\t\t\t\t->blood group:O-              \n");
                break;
            case 7:
            System.out.printf("\t\t\t\t\t->blood group:B-              \n");
                break;
            case 8:
            System.out.printf("\t\t\t\t\t->blood group:AB-             \n");
                break;								
        }
    }
    static void clear()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    static void display()
    {
	    
        System.out.printf("\t\t\t=================================================================\n");
        System.out.printf("\t\t\t*****  *      *****  ****   ****    *****     *****  *****  *****\n");
        System.out.printf("\t\t\t*   *  *      *      *   *  *       *         *   *  *      *   *\n");
        System.out.printf("\t\t\t*   *  *      *      *   *  *       *         *   *  *      *   *\n");
        System.out.printf("\t\t\t*****  *      *****  *   *  *  ***  *****     *****  *****  *   *\n");
        System.out.printf("\t\t\t*      *      *      *   *  *  * *  *         **     *      *   *\n");
        System.out.printf("\t\t\t*      *      *      *   *  *  * *  *         * *    *      *   *\n");
        System.out.printf("\t\t\t*      *****  *****  ****   **** *  *****     *  *   *****  ****\n");
        System.out.printf("\t\t\t=================================================================\n");   
    }
    public static void main(String[] args) {
        int temp,i=0;
        Scanner sc = new Scanner(System.in);
        try{
            int a[]= new int [8];
            Class.forName("oracle.jdbc.OracleDriver");    
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","chandu","chandu"); 
            Statement smt = con.createStatement(); 
            ResultSet brs = smt.executeQuery("select *from blood");
            while(brs.next()){
                for(i=0;i<8;i++){
                    a[i]=brs.getInt(i+1);
                }
            }
            do
            {
                clear();
                display();
                System.out.printf("\t\t\t\t\t+---+---------------------+\n");
                System.out.printf("\t\t\t\t\t| 1 |  Admin              |\n");
                System.out.printf("\t\t\t\t\t+---+---------------------+\n");
                System.out.printf("\t\t\t\t\t| 2 |  Donor              |\n");
                System.out.printf("\t\t\t\t\t+---+---------------------+\n");
                System.out.printf("\t\t\t\t\t| 3 |  blood requests     |\n");
                System.out.printf("\t\t\t\t\t+---+---------------------+\n");
                System.out.printf("\t\t\t\t\tEnter   your   choice    :");
                switch(sc.nextInt()){
                    case 1 -> {
                        clear();
                        display();
                        System.out.printf("\t\t\t\t\t+---+---------------------+\n");
                        System.out.printf("\t\t\t\t\t| 1 |  new registration   |\n");
                        System.out.printf("\t\t\t\t\t+---+---------------------+\n");
                        System.out.printf("\t\t\t\t\t| 2 |  login              |\n");
                        System.out.printf("\t\t\t\t\t+---+---------------------+\n");
                        System.out.printf("\t\t\t\t\tEnter   your   choice    :");
                        switch(sc.nextByte()){
                            case 1 -> {
                                clear();
                                display();
                                System.out.printf("\t\t\t\t\t****************************\n");
                                System.out.printf("\t\t\t\t\tEnter username:");
                                PreparedStatement psmt =con.prepareStatement("insert into admin values(?,?,?)");
                                psmt.setString(1,sc.next());
                                System.out.printf("\t\t\t\t\t****************************\n");
                                System.out.printf("\t\t\t\t\tEnter password:");
                                psmt.setString(2,sc.next());
                                System.out.printf("\t\t\t\t\t****************************\n");
                                System.out.printf("\t\t\t\t\tEnter phone number:");
                                psmt.setLong(3,sc.nextLong());
                                psmt.executeUpdate();
                                System.out.printf("\t\t\t\t\t---------------------------------------\n");
                                System.out.printf("\t\t\t\t\tcontents to file written successfully !\n");
                                System.out.printf("\t\t\t\t\t---------------------------------------\n");
                                Thread.sleep(2000);
                            }
                            case 2 ->{
                            clear();
                            display();
                            String username,password;
                            System.out.printf("\t\t\t\t\t****************************\n");
                            System.out.printf("\t\t\t\t\tEnter username:");
                            username=sc.next();
                            System.out.printf("\t\t\t\t\t****************************\n");
                            System.out.printf("\t\t\t\t\tEnter password:");
                            password=sc.next();
                            ResultSet rs = smt.executeQuery("select *from admin");
                            temp=0;
                            while(rs.next()){
                                if(username.equals(rs.getString(1)) && password.equals(rs.getString(2))){
                                    do{
                                        clear();
                                        display();
                                        System.out.printf("\t\t\t\t\t+---+---------------------+\n");
                                        System.out.printf("\t\t\t\t\t| 1 |  all user details   |\n");
                                        System.out.printf("\t\t\t\t\t+---+---------------------+\n");
                                        System.out.printf("\t\t\t\t\t| 2 |  pincode search     |\n");
                                        System.out.printf("\t\t\t\t\t+---+---------------------+\n");
                                        System.out.printf("\t\t\t\t\t| 3 | Blood group search  |\n");
                                        System.out.printf("\t\t\t\t\t+---+---------------------+\n");
                                        System.out.printf("\t\t\t\t\t| 4 | male donors list    |\n");
                                        System.out.printf("\t\t\t\t\t+---+---------------------+\n");
                                        System.out.printf("\t\t\t\t\t| 5 | female donors list  |\n");
                                        System.out.printf("\t\t\t\t\t+---+---------------------+\n");
                                        System.out.printf("\t\t\t\t\t| 6 | Blood packet details|\n");
							            System.out.printf("\t\t\t\t\t+---+---------------------+\n");
                                        System.out.printf("\t\t\t\t\t| 7 | Donate Blood        |\n");
                                        System.out.printf("\t\t\t\t\t+---+---------------------+\n");
                                        System.out.printf("\t\t\t\t\tEnter   your   choice    :");
                                        switch(sc.nextInt()){
                                            case 1 ->{
                                                clear();
                                                display();
                                                ResultSet drs = smt.executeQuery("select *from donor");
                                                temp=0;
                                                i=0;
                                                while(drs.next()){
                                                        System.out.printf("\t\t\t\t\t******************           *\n");
                                                        System.out.printf("\t\t\t\t\t#User %d details:             *\n",++i);
                                                        System.out.printf("\t\t\t\t\t******************           *\n");
                                                        System.out.println("\t\t\t\t\t->Name:"+drs.getString(1));
                                                        System.out.println("\t\t\t\t\t->weight:"+drs.getInt(2));
                                                        System.out.println("\t\t\t\t\t->Age:"+drs.getInt(3));
                                                        System.out.println("\t\t\t\t\t->gender:"+drs.getString(4));
                                                        System.out.println("\t\t\t\t\t->Phone:"+drs.getString(6));
                                                        System.out.println("\t\t\t\t\t->Pincode:"+drs.getString(9));
                                                        fun(drs.getInt(5));
                                                        temp=1;
                                                }
                                                if(temp==0){
                                                    System.out.printf("\t\t\t\t\t------------------------------------\n");
                                                    System.out.printf("\t\t\t\t\t            No user found           \n");
                                                    System.out.printf("\t\t\t\t\t------------------------------------\n");
                                                }
                                                Thread.sleep(2000);
                                            }
                                            case 2 -> {
                                                clear();
                                                display();
                                                System.out.printf("\t\t\t\t\t******************************\n");
                                                System.out.printf("\t\t\t\t\tEnter pincode:");
                                                String pincode=sc.next();
                                                ResultSet drs = smt.executeQuery("select *from donor");
                                                i=0;
                                                temp=0;
                                                while(drs.next()){
                                                    if(pincode.equals(drs.getString(9))){
                                                        System.out.printf("\t\t\t\t\t******************           *\n");
                                                        System.out.printf("\t\t\t\t\t#User %d details:             *\n",++i);
                                                        System.out.printf("\t\t\t\t\t******************           *\n");
                                                        System.out.println("\t\t\t\t\t->Name:"+drs.getString(1));
                                                        System.out.println("\t\t\t\t\t->weight:"+drs.getInt(2));
                                                        System.out.println("\t\t\t\t\t->Age:"+drs.getInt(3));
                                                        System.out.println("\t\t\t\t\t->gender:"+drs.getString(4));
                                                        System.out.println("\t\t\t\t\t->Phone:"+drs.getString(6));
                                                        fun(drs.getInt(5));
                                                        temp=1;
                                                    }   
                                                }
                                                if(temp==0){
                                                    System.out.printf("\t\t\t\t\t------------------------------------\n");
                                                    System.out.printf("\t\t\t\t\t No donors found  at pincode %s \n",pincode);
                                                    System.out.printf("\t\t\t\t\t------------------------------------\n");
                                                }
                                                Thread.sleep(2000);
                                            }
                                            case 3 -> {
                                                clear();
                                                display();
                                                System.out.printf("\t\t\t\t\t******************************\n");
                                                System.out.printf("\t\t\t\t\t+ --- + --- + --- + --- + --- + --- + --- + --- +\n");
                                                System.out.printf("\t\t\t\t\t|  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |\n");
                                                System.out.printf("\t\t\t\t\t+ --- + --- + --- + --- + --- + --- + --- + --- +\n");
                                                System.out.printf("\t\t\t\t\t|  A+ |  O+ |  B+ |  AB+|  A- |  O- |  B- |  AB-|\n");
                                                System.out.printf("\t\t\t\t\t+ --- + --- + --- + --- + --- + --- + --- + --- +\n");
                                                System.out.printf("\t\t\t\t\tEnter required blood group from above:");
                                                int tem=sc.nextInt();
                                                clear();
                                                display();
                                                ResultSet drs = smt.executeQuery("select *from donor");
                                                i=0;
                                                temp=0;
                                                while(drs.next()){
                                                    if(tem==drs.getInt(5)){
                                                        System.out.printf("\t\t\t\t\t******************           *\n");
                                                        System.out.printf("\t\t\t\t\t#User %d details:             *\n",++i);
                                                        System.out.printf("\t\t\t\t\t******************           *\n");
                                                        System.out.println("\t\t\t\t\t->Name:"+drs.getString(1));
                                                        System.out.println("\t\t\t\t\t->weight:"+drs.getInt(2));
                                                        System.out.println("\t\t\t\t\t->Age:"+drs.getInt(3));
                                                        System.out.println("\t\t\t\t\t->gender:"+drs.getString(4));
                                                        System.out.println("\t\t\t\t\t->Phone:"+drs.getString(6));
                                                        System.out.println("\t\t\t\t\t->Pincode:"+drs.getString(9));
                                                        temp=1;
                                                    }   
                                                }
                                                if(temp==0){
                                                    System.out.printf("\t\t\t\t\t------------------------------------\n");
                                                    System.out.printf("\t\t\t\t\t No donors found  with blood group  \n");
                                                    System.out.printf("\t\t\t\t\t------------------------------------\n");
                                                }
                                                Thread.sleep(2000);
                                            }
                                            case 4 -> {
                                                clear();
                                                display();
                                                ResultSet drs = smt.executeQuery("select *from donor");
                                                i=0;
                                                temp=0;
                                                while(drs.next()){
                                                    if(drs.getString(4).equals("male")){
                                                        System.out.printf("\t\t\t\t\t******************           *\n");
                                                        System.out.printf("\t\t\t\t\t#User %d details:             *\n",++i);
                                                        System.out.printf("\t\t\t\t\t******************           *\n");
                                                        System.out.println("\t\t\t\t\t->Name:"+drs.getString(1));
                                                        System.out.println("\t\t\t\t\t->weight:"+drs.getInt(2));
                                                        System.out.println("\t\t\t\t\t->Age:"+drs.getInt(3));
                                                        System.out.println("\t\t\t\t\t->Phone:"+drs.getString(6));
                                                        System.out.println("\t\t\t\t\t->Pincode:"+drs.getString(9));
                                                        fun(drs.getInt(5));
                                                        temp=1;
                                                    }   
                                                }
                                                if(temp==0){
                                                    System.out.printf("\t\t\t\t\t------------------------------------\n");
                                                    System.out.printf("\t\t\t\t\t           No Male donors           \n");
                                                    System.out.printf("\t\t\t\t\t------------------------------------\n");
                                                }
                                                Thread.sleep(2000);
                                            }
                                            case 5 -> {
                                                clear();
                                                display();
                                                ResultSet drs = smt.executeQuery("select *from donor");
                                                i=0;
                                                temp=0;
                                                while(drs.next()){
                                                    if(drs.getString(4).equals("female")){
                                                        System.out.printf("\t\t\t\t\t******************           *\n");
                                                        System.out.printf("\t\t\t\t\t#User %d details:             *\n",++i);
                                                        System.out.printf("\t\t\t\t\t******************           *\n");
                                                        System.out.println("\t\t\t\t\t->Name:"+drs.getString(1));
                                                        System.out.println("\t\t\t\t\t->weight:"+drs.getInt(2));
                                                        System.out.println("\t\t\t\t\t->Age:"+drs.getInt(3));
                                                        System.out.println("\t\t\t\t\t->Phone:"+drs.getString(6));
                                                        System.out.println("\t\t\t\t\t->Pincode:"+drs.getString(9));
                                                        fun(drs.getInt(5));
                                                        temp=1;
                                                    }   
                                                }
                                                if(temp==0){
                                                    System.out.printf("\t\t\t\t\t------------------------------------\n");
                                                    System.out.printf("\t\t\t\t\t           No female donors           \n");
                                                    System.out.printf("\t\t\t\t\t------------------------------------\n");
                                                }
                                                Thread.sleep(2000);
                                            }
                                            case 6 -> {
                                                clear();
                                                display();
                                                System.out.printf("\t\t\t+ -------------- + --- + --- + --- + --- + --- + --- + --- + --- +\n");
                                                System.out.printf("\t\t\t|  Blood group   |  A+ |  O+ |  B+ |  AB+|  A- |  O- |  B- |  AB-|\n");
                                                System.out.printf("\t\t\t+ -------------- + --- + --- + --- + --- + --- + --- + --- + --- +\n");
                                                System.out.printf("\t\t\t|  no.of packets |  %d  |  %d  |  %d  |  %d  |  %d  |  %d  |  %d  |  %d  |\n",a[0],a[1],a[2],a[3],a[4],a[5],a[6],a[7]);
                                                System.out.printf("\t\t\t+ -------------- + --- + --- + --- + --- + --- + --- + --- + --- +\n");
                                                Thread.sleep(2000);
                                            }
                                            case 7 -> {
                                                clear();
                                                display();
                                                System.out.printf("\t\t\t\t+ --- + --- + --- + --- + --- + --- + --- + --- +\n");
                                                System.out.printf("\t\t\t\t|  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |\n");
                                                System.out.printf("\t\t\t\t+ --- + --- + --- + --- + --- + --- + --- + --- +\n");
                                                System.out.printf("\t\t\t\t|  A+ |  O+ |  B+ |  AB+|  A- |  O- |  B- |  AB-|\n");
                                                System.out.printf("\t\t\t\t+ --- + --- + --- + --- + --- + --- + --- + --- +\n");
                                                System.out.printf("\t\t\t\tEnter blood group for donation:");
                                                int index=sc.nextInt()-1;
								                a[index]--;
                                                if(a[index]<0){
                                                    System.out.printf("\t\t\t\t\tNo blood packets");
                                                    fun(index+1);
                                                    a[index]=0;
                                                }
								                else{
									                System.out.printf("\t\t\t\t\tDonation succesful");
								                }
                                                Thread.sleep(2000);
                                            }
                                        }
                                        System.out.printf("\t\t\t\t\t*****************************\n");
                                        System.out.printf("\t\t\t\t\tDo you want to logout as admin:");
                                    }while(sc.next().charAt(0)!='y');
                                    temp=1;
                                    break;
                                }
                            }
                            if(temp==0){
                                System.out.printf("\t\t\t\t\t------------------------------------\n");
                                System.out.printf("\t\t\t\t\t username or password is incorrect. \n");
                                System.out.printf("\t\t\t\t\t------------------------------------\n");
                            }
                            }
                        }
                    }
                    case 2 -> {
                        clear();
                        display();
                        System.out.printf("\t\t\t\t\t+---+---------------------+\n");
                        System.out.printf("\t\t\t\t\t| 1 |  new registration   |\n");
                        System.out.printf("\t\t\t\t\t+---+---------------------+\n");
                        System.out.printf("\t\t\t\t\t| 2 |  login              |\n");	
                        System.out.printf("\t\t\t\t\t+---+---------------------+\n");
                        System.out.printf("\t\t\t\t\tEnter   your   choice    :");
                        switch(sc.nextInt()){
                            case 1:
                            clear();
                            display();
                            System.out.printf("\t\t\t\t\t***********\n");	
                            System.out.printf("\t\t\t\t\tEnter name:");
                            String name=sc.next();
                            System.out.printf("\t\t\t\t\t***********\n");
                            System.out.printf("\t\t\t\t\tEnter weight:");
                            byte weight=sc.nextByte();
                            System.out.printf("\t\t\t\t\t***********\n");
                            System.out.printf("\t\t\t\t\tEnter age:");
                            byte age=sc.nextByte();
                            System.out.printf("\t\t\t\t\t***********\n");
                            System.out.printf("\t\t\t\t\tEnter gender:");
                            String gender=sc.next();
                            System.out.printf("\t\t\t\t\t+ --- + --- + --- + --- + --- + --- + --- + --- +\n");
                            System.out.printf("\t\t\t\t\t|  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |\n");
                            System.out.printf("\t\t\t\t\t+ --- + --- + --- + --- + --- + --- + --- + --- +\n");
                            System.out.printf("\t\t\t\t\t|  A+ |  O+ |  B+ |  AB+|  A- |  O- |  B- |  AB-|\n");
                            System.out.printf("\t\t\t\t\t+ --- + --- + --- + --- + --- + --- + --- + --- +\n");
                            System.out.printf("\t\t\t\t\tEnter your blood group from above:");
                            int blood=sc.nextInt();
                            System.out.printf("\t\t\t\t\tEnter phone number:");
                            String phone=sc.next();
                            System.out.printf("\t\t\t\t\t***********\n");
                            System.out.printf("\t\t\t\t\tEnter username:");
                            String user=sc.next();
                            System.out.printf("\t\t\t\t\t***********\n");
                            System.out.printf("\t\t\t\t\tEnter password:");
                            String pass=sc.next();
                            System.out.printf("\t\t\t\t\t***********\n");
                            System.out.printf("\t\t\t\t\tEnter your pincode:");
                            String pin=sc.next();
                            System.out.printf("\t\t\t\t\t***********\n");
                            System.out.printf("\t\t\t\t\tAre you sufferning from any chronic disease:");
                            char disease=sc.next().charAt(0);
                            if(weight>=50 && age>=18 && disease!='Y' && disease!='y'){
                                PreparedStatement psmt =con.prepareStatement("insert into donor values(?,?,?,?,?,?,?,?,?)");
                                psmt.setString(1,name);
                                psmt.setInt(2,weight);
                                psmt.setInt(3,age);
                                psmt.setString(4,gender);
                                psmt.setInt(5,blood);
                                psmt.setString(6,phone);
                                psmt.setString(7,user);
                                psmt.setString(8,pass);
                                psmt.setString(9,pin);
                                psmt.executeUpdate();
                                System.out.printf("\t\t\t\t\t-----------------------------------------\n");
                                System.out.printf("\t\t\t\t\t   Your data is stored in the database   \n");
                                System.out.printf("\t\t\t\t\t-----------------------------------------\n");
                                System.out.println("\t\t\t\t\tDo you want to donote Blood now:");
                                System.out.print("\t\t\t\t\t");
                                if(sc.next().equals("yes")){
                                    a[blood-1]++;
                                }
                            }
                            else{
                                System.out.printf("\t\t\t\t\t-----------------------------------\n");
                                System.out.printf("\t\t\t\t\t You are unfit for blood donation. \n");
                                System.out.printf("\t\t\t\t\t-----------------------------------\n");
                            }
                            Thread.sleep(2000);
                            break;
                            case 2:
                            clear();
                            display();
                                System.out.printf("\t\t\t\t\t********************\n");
                                System.out.printf("\t\t\t\t\tEnter username:");
                                String username=sc.next();
                                System.out.printf("\t\t\t\t\t********************\n");
                                System.out.printf("\t\t\t\t\tEnter password:");
                                String password=sc.next();
                                System.out.printf("\t\t\t\t\t********************\n");
                                ResultSet drs = smt.executeQuery("select *from donor");
                                temp=0;
                                clear();
                                display();
                                while(drs.next()){
                                    if(username.equals(drs.getString(7)) && password.equals(drs.getString(8))){
                                        System.out.printf("\t\t\t\t\t******************           *\n");
                                        System.out.printf("\t\t\t\t\t#User details:               *\n");
                                        System.out.printf("\t\t\t\t\t******************           *\n");
                                        System.out.println("\t\t\t\t\t->Name:"+drs.getString(1));
                                        System.out.println("\t\t\t\t\t->weight:"+drs.getInt(2));
                                        System.out.println("\t\t\t\t\t->Age:"+drs.getInt(3));
                                        System.out.println("\t\t\t\t\t->gender:"+drs.getString(4));
                                        System.out.println("\t\t\t\t\t->Phone:"+drs.getString(6));
                                        System.out.println("\t\t\t\t\t->Pincode:"+drs.getString(9));
                                        fun(drs.getInt(5));
                                        temp=1;
                                        break;
                                    }
                                }
                                if(temp==0){
                                    clear();
                                    display();
                                    System.out.printf("\t\t\t\t\t------------------------------------\n");
                                    System.out.printf("\t\t\t\t\t username or password is incorrect. \n");
                                    System.out.printf("\t\t\t\t\t------------------------------------\n");
                                }
                                Thread.sleep(2000);
                            break;
                        }
                    }
                    case 3 -> {
                        clear();
                        display();
                        System.out.printf("\t\t\t\t\t-----------------\n");
                        System.out.printf("\t\t\t\t\t Contact admins: \n");
                        System.out.printf("\t\t\t\t\t-----------------\n");
                        ResultSet rs = smt.executeQuery("select *from admin");
                        while(rs.next()){
                            System.out.println("\t\t\t\t\t"+rs.getString(1)+":"+rs.getString(3));
                        }
                    }
                }
                System.out.printf("\t\t\t\t\t------------------------------------\n");
                System.out.println("\t\t\t\t\tDo you want to continue (Y/N):");
                System.out.print("\t\t\t\t\t");
            }while(sc.next().charAt(0)=='y');
            con.prepareStatement("delete from blood").executeQuery();
            PreparedStatement psmt =con.prepareStatement("insert into blood values(?,?,?,?,?,?,?,?)");
            for(i=1;i<9;i++){
                psmt.setInt(i,a[i-1]);
            }
            psmt.executeUpdate();
            con.commit();
            con.close();
            System.out.printf("                                   ----------------------------------------------\n");
            System.out.printf("                                         * * * * * * * *  * * * * * * * *\n");
            System.out.printf("                                         * * * * * * * *  * * * * * * * *\n");
            System.out.printf("                                               * *        * *         * * \n");
            System.out.printf("                                               * *        * *         * * \n");
            System.out.printf("                                               * *        * *         * *\n");
            System.out.printf("                                               * *        * *  * *    * *\n");
            System.out.printf("                                               * *        * *   * *   * *\n");
            System.out.printf("                                               * *        * * * * * * * * \n");
            System.out.printf("                                               * *        * * * * * * * * \n");
            System.out.printf("                                               * *                 * *\n");
            System.out.printf("                                   -----------------------------------------------\n");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}