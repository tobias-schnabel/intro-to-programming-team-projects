import java.util.Scanner;

public class Birthday {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter a day: ");
            int d = in.nextInt();
        
            System.out.println("Enter a month: ");
            int m = in.nextInt();

            System.out.println("Enter a year: ");
            int y = in.nextInt();   
         
        //set current date values
        int nowDay = java.time.LocalDate.now().getDayOfMonth();
        int nowMonth = java.time.LocalDate.now().getMonthValue();
        int nowYear = java.time.LocalDate.now().getYear();

         
        //print birthday message in case date & month  match todays date    
        if (d == nowDay && m == nowMonth){
            System.out.print("Congratulations, today is your birthday and you are ");
            System.out.print(Age(d, m, y, nowYear, nowDay, nowMonth) + " years old!");
        }
        //print message showing how many days until birthday 
        else {
            System.out.print("In " + JulianDayDifference(d, m, nowYear, nowDay, nowMonth) + " days you will be ");
            System.out.print(Age(d, m, y, nowYear, nowDay, nowMonth) + " years old!");
        }
    }


    public static int JulianDayDifference(int d, int m, int nowYear, int nowDay, int nowMonth){

        //calculates the day difference in case the date has yet to occur this year
        int daysDifference = (int) (JulianDay(d, m, nowYear) - JulianDay(nowDay, nowMonth, nowYear)); 
        int absDaysDifference = Math.abs(daysDifference);

        //calculates the day difference if the date has already occurred this year
        int daysTillBday = 365 - absDaysDifference;
        int returnValue = 0;

        //if the date has yet to occur this year, the return value equals daysDifference
        if (m > nowMonth || m == nowMonth){ 
            if(m > nowMonth){ returnValue = daysDifference;
            }     
            else if (m == nowMonth && d > nowDay){
                    returnValue = daysDifference; 
            }
            else if (m == nowMonth && d < nowDay){
                    returnValue = daysTillBday;
            }
         }
        //if the date has already occurred this year, the return value equals daysTillBday
        else   {returnValue = daysTillBday;
        }
        return returnValue;   
    }


    public static double JulianDay(int d, int m, int y){

        //entering Julian day number formulas
        double A = (14 - m)/12;
        double Y = y + 4800 - A;
        double M = m + 12*A -3;

        //Julian day number for the given date
        double julianDate = d + ((153*M+2)/5) + 365*Y + (Y/4) - (Y/100) + (Y/400) - 320454;

        return julianDate;
    }


    public static int Age(int d, int m, int y, int nowYear, int nowDay, int nowMonth){

        int age = 0;

        //if the date has yet to occur this year, age equals the difference between 
        //the current year and the year of birth
        if (m > nowMonth || m == nowMonth){ 
            if(m > nowMonth){ age = nowYear - y;
            }     
            else if (m == nowMonth && d >= nowDay){
                    age = nowYear -y; 
            }
            else if (m == nowMonth && d < nowDay){
                    age = nowYear - y + 1;
            }
         }
        //if the date has already occurred this year, age equalsthe difference between
        //the current year and the year of birth plus one
        else   {age = nowYear - y + 1;
        }
        return age;
    }
}

