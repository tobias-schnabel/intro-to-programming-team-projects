/*RunTimesMatrixMulitplication.java
        Authors: Dohmen, RJH (i6250494)
        Schnabel, CT (i6255807)
 */

public class Santa {

    public static void main(String[] args){

        IntegerStack randomStack;

        //counter vars
        int santaWins = 0;
        int alabWins = 0;
        int ties = 0;

        //execute loop 100k times
        for (int dayCounter= 0; dayCounter<= 100000; dayCounter++){
            randomStack = randomStack(12, 12);
            int outcome = game(randomStack);
           if (outcome == -1){
               alabWins += 1;
           } else if (outcome == 1){
               santaWins += 1;
           } else{ ties += 1;}
           } //close loop
        // print output
            System.out.println("The game was played 100.000 times, each time using a new randomly generated stack of presents.");
            System.out.println("Of those 100.000 times, Santa won " + santaWins + " times, Alabaster won " + alabWins + " times, and there were " + ties + " ties.");

    } //close main

    //ﬁrst write a method that creates a random stack of 12 red and 12 blue presents
    public static IntegerStack randomStack (int blue,  int red){
       IntegerStack returnStack = new IntegerStack();

        int countBlue = blue; //red is 0 //12
       int countRed = red; //blue is 1 //12
       double probability; //initialize probability

       while (returnStack.size() != 24){
           probability = ((double) countRed) / ((double) (countRed + countBlue));
            if (Math.random() <= probability && countRed > -1){
                returnStack.push(0); //red
                countRed --;
            } else if (Math.random() > probability && countBlue > -1){
                returnStack.push(1); //blue
                countBlue --;
            } else if (returnStack.size() == 24) {break;}

       } //close loop

        return returnStack;
    } //close method

    public static int game(IntegerStack inputStack){
        int santaCounter = 0; //santa's presents
        int alabasterCounter = 0; //alab's presents
        int firstPresent, secondPresent; //storage vars to compare
        //blue (Alabaster) = 1 and red (Santa) = 0
        for(int dayCounter = 0; dayCounter<24; dayCounter++){
            double coinFlip = (Math.random());

            // Santa
            if(coinFlip > 0.5){
                if(dayCounter != 23){
                    firstPresent = inputStack.pop();
                    secondPresent = inputStack.pop();
                    if((firstPresent == 0 && secondPresent == 1) || (firstPresent == 1 && secondPresent == 0)){
                        santaCounter += 1;
                        inputStack.push(1);
                    } else if (firstPresent == 0 && secondPresent == 0){
                        santaCounter += 1;
                        inputStack.push(0);
                    } else if (firstPresent == 1 && secondPresent == 1){
                        inputStack.push(1);
                    }
                } else {
                    firstPresent = inputStack.pop();
                    if(firstPresent == 0){
                        santaCounter += 1;
                    }
                }
            }

            // Alabaster'
            if(coinFlip <= 0.5){
                if(dayCounter!= 23){
                    firstPresent = inputStack.pop();
                    secondPresent = inputStack.pop();
                    if(firstPresent != secondPresent){
                        alabasterCounter++;
                        inputStack.push(0);
                    } else if(firstPresent == 1){
                        alabasterCounter++;
                        inputStack.push(0);
                    } else if(firstPresent == 0){
                        inputStack.push(1);
                    }
                }  else{
                    firstPresent = inputStack.pop();
                    if(firstPresent == 0){
                        alabasterCounter++;
                        }
                    }
            }
        }
        int outcome = 0; //tie
        if(alabasterCounter < santaCounter){
            outcome = 1;
        }
        if(alabasterCounter > santaCounter){
            outcome = -1;
        }

        return outcome;
    } //close method

} //close class
