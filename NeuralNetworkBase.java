//Base for a neural network

public class Main{
    private int[][] inputs = {{0, 0, 1}, {1, 1, 1}, {1,0,1}, {0,1,1}};
    private int[] outputs = {0, 1, 1, 0};
    private float[][] weights = new float[4][3];
    public Main(){
        for(int i = 0; i < 4; i++){  
        for(int x = 0; x < 3; x++){
         weights[i][x] = (float)(Math.random()*3)-1;   
        }
        }
    }
    public void getWeights(){
        for(int i = 0; i<weights.length; i++){
            for(float x: weights[i]){
                System.out.print(x);
            }
        }
    }
    public void avgWeights(){
        for(int i = 0; i<3; i++){
            weights[0][i]=(weights[0][i]+weights[1][i]+weights[2][i]+weights[3][i])/4;
        }
        
    }
    public int[] getOutput(){
        float a;
        float b;
        float c;
        int[] output = new int[4];
        for(int i = 0; i<weights.length; i++){
                a = (weights[i][0]*(float)inputs[i][0]);
                b = (weights[i][1]*(float)inputs[i][1]);
                c = (weights[i][2]*(float)inputs[i][2]);
                output[i] = (int)((a+b+c));
        }
        return output;
    }
    
    public void train(){
       
       for(int x = 0; x<inputs.length; x++){
       for(int i = 0; i < 100000; i++){
           float guess = (inputs[x][0]*weights[x][0])+(inputs[x][2]*weights[x][2])+(inputs[x][1]*weights[x][1]);    
               
               for(int a = 0; a<3; a++){
                   weights[x][a]+= 0.0001*(outputs[x]-guess)*(weights[x][a])*(float)(outputs[x]); 
               }
               
               
           
           
       } 
       }
       this.avgWeights();
       
    }
    public static void main(String[] args){
      Main m1 = new Main();
      m1.train();
      m1.getWeights();
      int[] outputs = m1.getOutput();
      System.out.println();
      for(int i = 0; i<=3; i++){
      System.out.println(outputs[i]);
      }
    }
}
