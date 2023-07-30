import java.util.*;
class Main{
    public static void main(String args[]){
        Scanner scan=new Scanner(System.in);
        boolean state=false;
        System.out.println("\t\tWelcome to the ATM");
        System.out.println("\t_______________________________________________________");
        System.out.println("1)Create  \n2)EXit");
        System.out.println("Select a option to proceed..................");
        int option=scan.nextInt();
        User users=new User();
        switch(option) 
        {
            case 1:users.register();break;
            case 2:System.exit(0);break;
            default:System.out.println("invalid input...............");
        }
        System.out.println("\nLoggig in.......");
        while(!state){
        state=users.login();
        }
       System.out.println("login successful");
        char ch;
        do{
            System.out.println("\033[H\033[2J");
            System.out.flush();
            System.out.println("1.withdraw\n2.deposite\n3.balance check\n4.transaction history\n5.exit");
            System.out.println("Select a option to proceed..................");
            option=scan.nextInt();
            switch(option){
               case 5:System.exit(0);
               case 1:users.withdraw();break;
               case 2:users.deposite();break;
               case 3:users.balanceCheck();break;
               case 4:users.transactionHistory();break;
               default:System.out.println("invalid input");break;
            }
            System.out.println("Do you want to continue(Y/N) : ");
           ch=scan.next().charAt(0);
          }while(ch=='y'||ch=='Y');
          System.out.println("exiting..........");
    }
}
class User{
    String accountNumber="00000000000",name,password="1234",transaction="";
    double accountBalance=500.00;
    Scanner scan=new Scanner(System.in);
  void register(){
    System.out.println("\t\tWELCOME TO THE USER ACCOUNT REGISTERATION");
      System.out.println("\t\t__________________________________");
      System.out.print("Enter Account Holder Name       :  ");
      name=scan.nextLine();
      System.out.print("Enter Account Number            :  ");
      accountNumber=scan.nextLine();
      System.out.print("Enter password to set           :  ");
      password=scan.nextLine();
  }
  void updateAccount(){
      System.out.print("Enter Account Number            :  ");
      String accountNumber=scan.nextLine();
      if(accountNumber.equals(this.accountNumber)){
      System.out.print("Enter old password           :  ");
      String oldpassword=scan.nextLine();
      if(oldpassword.equals(this.password))
      {
        System.out.println("Enter new password : ");
        String currentPassword=scan.nextLine();
        this.password=currentPassword;
      }
      else
      {
        System.out.println("password mismatch............");
      }
    }
  }
  boolean login(){
       System.out.print("Enter Account Number                     :  ");
       String accountNumber=scan.nextLine();
       if(this.accountNumber.equals(accountNumber))
       {
         System.out.print("Enter your password to login           :  ");
         String password=scan.nextLine();
         if((this.password).equals(password))
         {
            return true;
         }
         else
         {
          System.out.println("Invalid Password -try again.....");    
         }
       }
       else
       {
          System.out.println("Invalid Account number -try again.....");
       }
  return false;
  }
  void withdraw(){
    System.out.print("Enter amount to withdraw       : ");
    double amount=scan.nextDouble();
    if(amount<accountBalance)
    {
      this.accountBalance=this.accountBalance-amount;
      this.transaction=this.transaction+amount+"rs withdrawn..........\n";
    }
    else
    {
        System.out.println("insufficient balance................");
    }
  }
  void deposite(){
     System.out.print("Enter amount to deposite       : ");
    double amount=scan.nextDouble();
    this.accountBalance+=amount;
    this.transaction+=amount+" rs deposited\n";
  }
  void transactionHistory(){
    System.out.println(this.transaction);
  }
  void balanceCheck(){
    System.out.println("Balanace \t\t: "+accountBalance+" rs");
  }
}
