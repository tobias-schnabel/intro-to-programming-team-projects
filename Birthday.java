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

        int ageYears = nowYear - y;
         
        //print birthday message in case date & month  match todays date    
        if (d == nowDay && m == nowMonth){
            System.out.print("Congratulations, today is your birthday and you are " + ageYears + " years old!");
        }
        //print message showing how many days until birthday 
        else { int ageYears1 = ageYears + 1;
            System.out.print("In " + JulianDayDifference(d, m, nowYear, nowDay, nowMonth) + " days you will be ");
               System.out.print(ageYears1 + " years old.");
               }
    }


    public static int JulianDayDifference(int dayBday, int monthBday, int nowYear, int nowDay, int nowMonth){

        int daysDifference = (int) (JulianDay(dayBday, monthBday, nowYear) - JulianDay(nowDay, nowMonth, nowYear)); 
        int absDaysDifference = Math.abs(daysDifference);
        int daysTillBday = 365 - absDaysDifference;
        int returnValue = 0;

        if (monthBday > nowMonth || monthBday == nowMonth){ 
            if(monthBday > nowMonth){ returnValue = absDaysDifference;
            }     
            else if (monthBday == nowMonth && dayBday > nowDay){
                    returnValue = daysDifference; 
            }
            else if (monthBday == nowMonth && dayBday < nowDay){
                    returnValue = daysTillBday;
            }
         }
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
}

