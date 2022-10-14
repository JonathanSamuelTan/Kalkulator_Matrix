import javax.swing.*;
public class App {
    public static void main(String[] args) throws Exception {
       boolean cont = true;
        while(cont){
            int option = Integer.parseInt(JOptionPane.showInputDialog("Welcome to Matrix Calculator\nType 1 to create a new problem or 2 to exit"));
            if(option != 1 && option !=2){
                JOptionPane.showMessageDialog(null, "Invalid Input");
            } 
            switch (option){
                case 1 :
                    // Create Matrix 1
                        int[][] matrix1 = Create_Matrix("Matrix 1");
                    // Create matrix 2
                        int[][] matrix2 = Create_Matrix("Matrix 2");
                    
                    // Choose type of operation :
                        char operation = JOptionPane.showInputDialog("Choose type of operation ( + | - | * ) :").charAt(0);
                        switch (operation) {
                            case '+':
                                if(Add_Substract_Validation(matrix1, matrix2)){
                                    Display_Matrix(Add_Matrix(matrix1, matrix2));
                                }else{
                                    JOptionPane.showMessageDialog(null, "Error : Matrixes are not the same size");
                                }
                                break;
                            case '-':
                                if(Add_Substract_Validation(matrix1, matrix2)){
                                    Display_Matrix(Substract_Matrix(matrix1, matrix2));
                                }else{
                                    JOptionPane.showMessageDialog(null, "Error : Matrixes are not the same size");
                                }
                                break;
                            case '*':
                                if(Multiply_Validation(matrix1, matrix2)){
                                    Display_Matrix(Multiply_Matrix(matrix1, matrix2));
                                }else{
                                    JOptionPane.showMessageDialog(null, "Error : Matrix 1 coloum must same with matrix 2 row");
                                }
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Invalid Operation");
                                break;
                        }

                        // exit or continue
                        option = Integer.parseInt(JOptionPane.showInputDialog("Type 1 if you would like to continue using the calcultor,\ntype 2 if you would like to exit"));
                        if(option == 1){
                            cont = true;
                        }else if(option == 2){
                            JOptionPane.showMessageDialog(null, "Thank you for using Matrix Calculator");
                            cont = false;
                        }else{
                            JOptionPane.showMessageDialog(null, "Invalid option");
                            cont = false;
                        }
                break;
                case 2 :
                    cont = false;
                    System.out.println("Thank you for using Matrix Calculator");
                    break;
                
                default:
                    System.out.println("Invalid option");
                    break;
            }
        } 
    }
    
    public static boolean Add_Substract_Validation(int[][]matrix1,int[][] matrix2){
        boolean check = false;
        int Rows1 = matrix1.length;
		int Col1 = matrix1[0].length;
		int Rows2 = matrix2.length;
		int Col2 = matrix2[0].length;
		if(Rows1 == Rows2 && Col1 == Col2){
			check = true;
		}
		return check;
    }

    public static boolean Multiply_Validation(int[][]matrix1,int[][] matrix2){
        boolean check = false;
        if(matrix1[0].length == matrix2.length){
            check = true;
        }
        return check;
    }

    public static int[][] Create_Matrix(String matrix_name){
        int row = Integer.parseInt(JOptionPane.showInputDialog(String.format("Input %s row length : ",matrix_name)));
        int col = Integer.parseInt(JOptionPane.showInputDialog(String.format("Input %s col length : ",matrix_name)));
        // create matrix 
        int[][] matrix = new int[row][col];
        for(int i = 0 ; i< row ; i++){
            for(int j = 0 ; j<col ; j++){
                matrix[i][j] = Integer.parseInt(JOptionPane.showInputDialog(String.format("Input Matrix[ Row : %d][ Col : %d] : ",i,j)));
            }
        }
        return matrix;
    }

    public static int[][] Add_Matrix(int[][] matrix1, int[][] matrix2){
        int[][]result = new int[matrix1.length][matrix1[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result ;
    }

    public static int[][] Substract_Matrix(int[][] matrix1, int[][] matrix2){
        int[][]result = new int[matrix1.length][matrix1[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return result;
    }

    public static int[][] Multiply_Matrix(int[][] matrix1, int[][] matrix2){
        int[][]result = new int[matrix1.length][matrix2[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                for (int k = 0; k < matrix1[0].length; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }

    public static void Display_Matrix(int[][] matrix){
        JFrame f = new JFrame(); 
        JTable table = new JTable(matrix.length, matrix[0].length);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                table.setValueAt(matrix[i][j], i, j);
            }
        }
        JScrollPane sp=new JScrollPane(table);    
        f.add(sp);          
        f.setSize(200,200);    
        f.setVisible(true);    
        JOptionPane.showMessageDialog(null,"See the result at the new windows");
    }
}
