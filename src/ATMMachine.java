import java.util.Scanner;
import java.io.*;
public class ATMMachine
{
    //Made by Denislav Mladenov!!!
    public static void checkBalance()
    {
        System.out.println("\tВашият текущ баланс е " + BalanceInquiry.getBalance());
    }

    public static void withdrawMoney()
    {
        if(BalanceInquiry.balance==0)
        {
            System.out.println("\tТекущият ви баланс е нула.");
            System.out.println("\tНе можете да теглите!");
            System.out.println("\tПърво трябва да депозирате пари.");
        }
        else if(BalanceInquiry.balance<=500)
        {
            BalanceInquiry.balance = BalanceInquiry.balance - Withdraw.withdraw;
            System.out.println("\n\tИзтегляте сума от Php " + Withdraw.withdraw);
        }
        else if(Withdraw.withdraw > BalanceInquiry.balance)
        {
            System.out.println("\tСтойността която теглите надвишава баланса ви.");
            System.out.println("\tМоля проверете въведената сума.");
        }
        else
        {
            System.out.println("\tНямате достатъчно пари за теглене");
            System.out.println("\tПроверете баланса си, за да видите парите си в банка.");
        }
    }

    public static void depositMoney()
    {
        System.out.println("\tВие депозирахте сумата от " + Deposit.getDeposit());
    }
    //Made by Denislav Mladenov!!!
    public static void main(String[] args)
    {
        Scanner read = new Scanner(System.in);
        int select = 0;
        int choice = 0;

        System.out.println("====================================================");
        System.out.println("\tДобре дошли в този АТМ.");
        System.out.println("====================================================");
        System.out.println();

        do
        {try
        {
            do {

                System.out.println("\tМоля изберете ATM Транзакции.");
                System.out.println("\tНатисни [1] Депозит");
                System.out.println("\tНатисни [2] Изтегляне");
                System.out.println("\tНатисни [3] Запитване за баланс");
                System.out.println("\tНатисни [4] Изход");

                System.out.print("\n\tКаква операция ще извършите? ");
                select = read.nextInt();

                if(select>4)
                {
                    System.out.println("\n\tМоля изберете правилна транзакция.");
                }
                else
                {
                    switch (select)
                    {
                        case 1:
                            System.out.print("\n\tВъведете желаната за депозиране сума: ");
                            Deposit.deposit = read.nextDouble();
                            BalanceInquiry.balance = Deposit.deposit + BalanceInquiry.balance;
                            depositMoney();
                            break;

                        case 2:

                            System.out.print("\n\tЗа да изтеглите се уверете че имате достатъчно салдо в сметката.");
                            System.out.println();
                            System.out.print("\tВъведете сума за теглене: ");
                            Withdraw.withdraw = read.nextDouble();
                            withdrawMoney();
                            break;

                        case 3:
                            checkBalance();
                            break;

                        default:
                            System.out.print("\n\tТранзакцията приключи.");
                            break;

                    }
                }

            }while(select>4);

            do {
                try
                {
                    System.out.println("\n\tЩе опитате ли да направите нова транзакция?");
                    System.out.println("\n\tНатисни [1] Да \n\tНатисни [2] Не");
                    System.out.print("\tВъведи избор: ");
                    choice = read.nextInt();

                    if(choice>2)
                    {
                        System.out.print("\n\tМоля изберете правилна опция.");
                    }
                }

                catch(Exception e)
                {
                    System.out.println("\tГрешно въвеждане! Молч въведете само число.");
                    read = new Scanner(System.in);
                    System.out.println("\tВъведете вашият избор:");
                    choice = read.nextInt();
                }
            } while(choice>2);
        }
        catch(Exception e)
        {
            System.out.println("\tГрешно въвеждане! Моля въведете само число.");
            read = new Scanner(System.in);
            System.out.println("\tВъведете избора си:");
            select = read.nextInt();
        }

        }while(choice<=1);

        System.out.println("\n\tБлагодаря че използвахте тази ATM машина.");
    }
}
//Made by Denislav Mladenov!!!