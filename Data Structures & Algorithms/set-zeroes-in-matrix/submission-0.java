class Solution {
    public void setZeroes(int[][] matrix) {
        int n= matrix.length;
        int m= matrix[0].length;

        boolean checkLastRow = false;
        for(int i=0;i<m;i++){
            if(matrix[n-1][i]==0){
                checkLastRow=true;
            }
        }

        for(int i=0;i<n-1;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    //make whole row zero and mark last row exact column zero
                    for(int k=0;k<m;k++){
                        if(matrix[i][k]==0){
                            matrix[n-1][k]=0;
                        }else{
                            matrix[i][k]=0;
                        }
                    }
                    break;
                }
            }
        }

        //traverse last row

        for(int i=0;i<m;i++){
            if(matrix[n-1][i]==0){
                //make complete column zero
                for(int j=0;j<n;j++){
                    matrix[j][i]=0;
                }
            }
        }

        if(checkLastRow){
            for(int j=0;j<m;j++){
                matrix[n-1][j]=0;
            }
        }
        
    }
}
