import java.sql.*;




    public class DataBase {

        public static void main(String[] args) {

            Connection connection = null;
            DataBase d = new DataBase();
            try{
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/","postgres","Loveu@546");
         }
         catch (Exception e){
                e.printStackTrace();
            }finally {
                if(connection != null){
                    try{
                        connection.close();
                    }catch (Exception se){
                        se.printStackTrace();
                    }
                }
            }




        }

        public void setData(Connection connection,String uname, String pawd){
            System.out.println(uname+pawd);

            try {
                PreparedStatement preparedStatement = connection.prepareStatement("Insert into Login(uname, pwd) VALUES (?,?)");
//                preparedStatement.executeQuery("");
                preparedStatement.setString(1,uname);
                preparedStatement.setString(2,pawd);
preparedStatement.execute();


            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        public String getData(Connection connection, String un){

            String st=un;
            System.out.println(st);
            try{
                PreparedStatement statement = connection.prepareStatement("select * from Login where uname=?");
                statement.setString(1, un);
                ResultSet resultSet = statement.executeQuery();
                    System.out.println("im here now");

                    while (resultSet.next()) {
                        return resultSet.getString("pwd");
                    }

                } catch (SQLException e) {
                e.printStackTrace();
            }
            return "Hi";
        }


    }


