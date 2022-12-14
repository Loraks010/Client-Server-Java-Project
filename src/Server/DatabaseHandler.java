package Server;
import ProductTree.*;
import User.User;
import User.Order;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseHandler extends Configs{
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException,SQLException
    {
        String connection_str="jdbc:mysql://"+ dbHost +":"+dbPort +"/"+dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection=DriverManager.getConnection(connection_str,dbUser,dbPass);
        return dbConnection;
    }
    public int regUser(String login,String password,int locked,int admin)
    {
        try {
        String select="SELECT * FROM " + Const.USERS_TABLE + " WHERE " + Const.USER_LOGIN + "=?";

        String insert= "INSERT INTO " + Const.USERS_TABLE + "("+ Const.USER_LOGIN +","+ Const.USER_PASSWORD +","+ Const.USER_STATUS+ ","+ Const.USER_ADMIN+")"
                + "VALUES(?,?,?,?)";
            ResultSet resSet=null;
            PreparedStatement prSt=getDbConnection().prepareStatement(select);

            prSt.setString(1,login);
            resSet=prSt.executeQuery();
            if(!resSet.next()) {


                prSt = getDbConnection().prepareStatement(insert);
                prSt.setString(1, login);
                prSt.setString(2, password);
                prSt.setInt(3, locked);
                prSt.setInt(4, admin);

                prSt.executeUpdate();
                return 0;
            }
            else {
                return 1;
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public User getUser(User us)
    {
        ResultSet resSet=null;
        String select="SELECT * FROM " + Const.USERS_TABLE + " WHERE "
                + Const.USER_LOGIN + "=? AND " + Const.USER_PASSWORD +"=?";

        try {
            PreparedStatement prSt=getDbConnection().prepareStatement(select);

            prSt.setString(1,us.login);
            prSt.setString(2,us.password);
            resSet=prSt.executeQuery();


            if (resSet.next())
            {
                User ob=new User(resSet.getInt(1),resSet.getString(2),
                        resSet.getString(3), resSet.getInt(5), resSet.getInt(4));
                return ob;
            }
            User nob = new  User(0,"0","0",0,0);
                return nob;

        } catch (SQLException | ClassNotFoundException e)
                {
            throw new RuntimeException(e);
        }

    }
    public ArrayList<CPU> getCPU()
    {

        ResultSet resSet=null;
        ArrayList<CPU> list =new ArrayList<>();

        String select="SELECT * FROM " + Const.PRODUCT_TABLE +","+ Const.CPU_TABLE +" WHERE "
                + Const.CPU_PRODUCT_ID + " = " + Const.PRODUCT_ID;

        try {
            PreparedStatement prSt=getDbConnection().prepareStatement(select);
            resSet=prSt.executeQuery();
            for(int i=0;resSet.next();resSet.next())
            {
                CPU cpu = new CPU(resSet.getInt(1),resSet.getString(2),resSet.getDouble(3),
                        resSet.getString(4),resSet.getDouble(5),resSet.getDouble(6),
                        resSet.getInt(7), resSet.getInt(8),resSet.getInt(9));
                list.add(i, cpu);

            }
            return list;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public void setCPU(CPU ob)
    {
        ResultSet resSet=null;
        String insert= "INSERT INTO " + Const.PRODUCT_TABLE + "("+ Const.PRODUCT_NAME +
                ","+ Const.PRODUCT_PRICE+ ","+ Const.PRODUCT_MAKER+")"
                + "VALUES(?,?,?)";
        try {
            PreparedStatement prSt=getDbConnection().prepareStatement(insert);
            prSt.setString(1,ob.getName());
            prSt.setDouble(2, ob.getPrice());
            prSt.setString(3,ob.getMaker());
            prSt.executeUpdate();

            String select="SELECT "+ Const.PRODUCT_ID+ " FROM " + Const.PRODUCT_TABLE + " WHERE "+ Const.PRODUCT_NAME
                    + "=?";

            prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1,ob.getName());
            resSet=prSt.executeQuery();
            if(resSet.next()) {
                ob.setId(resSet.getInt(1));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        insert= "INSERT INTO " + Const.CPU_TABLE + "("+ Const.CPU_FREQUENCY +
                 ","+ Const.CPU_TURBO_BOOST_FREQUENCY+ ","+ Const.CPU_NUMBER_OF_CORES+","+ Const.CPU_TECHNICAL_PROCESS+
                 ","+ Const.CPU_TDP+","+ Const.CPU_PRODUCT_ID+")" + "VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement prSt=getDbConnection().prepareStatement(insert);
            prSt.setDouble(1,ob.getFrequency());
            prSt.setDouble(2,ob.getTurbo_boost_frequency());
            prSt.setInt(3,ob.getNumber_of_cores() );
            prSt.setInt(4,ob.getTechnical_process());
            prSt.setInt(5,ob.getTdp() );
            prSt.setInt(6,ob.getId());
            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Product> getProduct()
    {

        ResultSet resSet=null;
        ArrayList<Product> list =new ArrayList<>();

        String select="SELECT * FROM " + Const.PRODUCT_TABLE;

        try {
            PreparedStatement prSt=getDbConnection().prepareStatement(select);
            resSet=prSt.executeQuery();
            for(int i=0;resSet.next();i++)
            {
                Product ob = new Product(resSet.getInt(1),resSet.getDouble(3),resSet.getString(2),
                        resSet.getString(4));
                list.add(i, ob);
            }
            return list;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void setGraphicsCard(Graphics_card ob) {
        ResultSet resSet=null;
        String insert= "INSERT INTO " + Const.PRODUCT_TABLE + "("+ Const.PRODUCT_NAME +
                ","+ Const.PRODUCT_PRICE+ ","+ Const.PRODUCT_MAKER+")"
                + "VALUES(?,?,?)";
        try {
            PreparedStatement prSt=getDbConnection().prepareStatement(insert);
            prSt.setString(1,ob.getName());
            prSt.setDouble(2, ob.getPrice());
            prSt.setString(3,ob.getMaker());
            prSt.executeUpdate();

            String select="SELECT "+ Const.PRODUCT_ID+ " FROM " + Const.PRODUCT_TABLE + " WHERE "+ Const.PRODUCT_NAME
                    + "=?";

            prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1,ob.getName());
            resSet=prSt.executeQuery();
            if(resSet.next()) {
                ob.setId(resSet.getInt(1));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        insert= "INSERT INTO " + Const.GRAPHICS_CARD_TABLE + "("+ Const.GRAPHICS_CARD_FREQUENCY+
                ","+ Const.GRAPHICS_CARD_NUMBER_OF_CORES+ ","+ Const.GRAPHICS_CARD_TDP+","+ Const.GRAPHICS_CARD_PRODUCT_ID+")"
                + "VALUES(?,?,?,?)";
        try {
            PreparedStatement prSt=getDbConnection().prepareStatement(insert);
            prSt.setDouble(1,ob.getFrequency());
            prSt.setInt(2,ob.getNumber_of_cores());
            prSt.setInt(3, ob.getTdp());
            prSt.setInt(4,ob.getId());
            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void setScreen(Screen ob) {
        ResultSet resSet=null;
        String insert= "INSERT INTO " + Const.PRODUCT_TABLE + "("+ Const.PRODUCT_NAME +
                ","+ Const.PRODUCT_PRICE+ ","+ Const.PRODUCT_MAKER+")"
                + "VALUES(?,?,?)";
        try {
            PreparedStatement prSt=getDbConnection().prepareStatement(insert);
            prSt.setString(1,ob.getName());
            prSt.setDouble(2, ob.getPrice());
            prSt.setString(3,ob.getMaker());
            prSt.executeUpdate();

            String select="SELECT "+ Const.PRODUCT_ID+ " FROM " + Const.PRODUCT_TABLE + " WHERE "+ Const.PRODUCT_NAME
                    + "=?";

            prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1,ob.getName());
            resSet=prSt.executeQuery();
            if(resSet.next()) {
                ob.setId(resSet.getInt(1));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        insert= "INSERT INTO " + Const.SCREEN_TABLE + "("+Const.SCREEN_FREQUENCY_OF_UPDATE+ ","+ Const.SCREEN_DIAMETER+
                ","+ Const.SCREEN_SCREEN_RESOLUTION+","+ Const.SCREEN_PRODUCT_ID+")"
                + "VALUES(?,?,?,?)";
        try {
            PreparedStatement prSt=getDbConnection().prepareStatement(insert);
            prSt.setDouble(1,ob.getFrequency_of_update());
            prSt.setString(2,ob.getDiameter());
            prSt.setString(3, ob.getScreen_resolution());
            prSt.setInt(4,ob.getId());
            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void setKeyboard(Keyboard ob) {
        ResultSet resSet=null;
        String insert= "INSERT INTO " + Const.PRODUCT_TABLE + "("+ Const.PRODUCT_NAME +
                ","+ Const.PRODUCT_PRICE+ ","+ Const.PRODUCT_MAKER+")"
                + "VALUES(?,?,?)";
        try {
            PreparedStatement prSt=getDbConnection().prepareStatement(insert);
            prSt.setString(1,ob.getName());
            prSt.setDouble(2, ob.getPrice());
            prSt.setString(3,ob.getMaker());
            prSt.executeUpdate();

            String select="SELECT "+ Const.PRODUCT_ID+ " FROM " + Const.PRODUCT_TABLE + " WHERE "+ Const.PRODUCT_NAME
                    + "=?";

            prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1,ob.getName());
            resSet=prSt.executeQuery();
            if(resSet.next()) {
                ob.setId(resSet.getInt(1));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        insert= "INSERT INTO " + Const.KEYBOARD_TABLE + "("+Const.KEYBOARD_TYPE+ ","+ Const.KEYBOARD_SWITCHES+
                ","+ Const.KEYBOARD_RGB+","+ Const.KEYBOARD_PRODUCT_ID+")"
                + "VALUES(?,?,?,?)";
        try {
            PreparedStatement prSt=getDbConnection().prepareStatement(insert);
            prSt.setString(1,ob.getType());
            prSt.setString(2,ob.getSwitches());
            prSt.setInt(3, ob.isRgb());
            prSt.setInt(4,ob.getId());
            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void setRam(Ram ob) {
        ResultSet resSet=null;
        String insert= "INSERT INTO " + Const.PRODUCT_TABLE + "("+ Const.PRODUCT_NAME +
                ","+ Const.PRODUCT_PRICE+ ","+ Const.PRODUCT_MAKER+")"
                + "VALUES(?,?,?)";
        try {
            PreparedStatement prSt=getDbConnection().prepareStatement(insert);
            prSt.setString(1,ob.getName());
            prSt.setDouble(2, ob.getPrice());
            prSt.setString(3,ob.getMaker());
            prSt.executeUpdate();

            String select="SELECT "+ Const.PRODUCT_ID+ " FROM " + Const.PRODUCT_TABLE + " WHERE "+ Const.PRODUCT_NAME
                    + "=?";

            prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1,ob.getName());
            resSet=prSt.executeQuery();
            if(resSet.next()) {
                ob.setId(resSet.getInt(1));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        insert= "INSERT INTO " + Const.RAM_TABLE + "("+Const.RAM_VOLUME+ ","+ Const.RAM_QUANTITY_IN_THE_SET+
                ","+ Const.RAM_FREQUENCY+ ","+ Const.RAM_TIMINGS+","+ Const.RAM_PRODUCT_ID+")"
                + "VALUES(?,?,?,?,?)";
        try {
            PreparedStatement prSt=getDbConnection().prepareStatement(insert);
            prSt.setInt(1,ob.getVolume());
            prSt.setInt(2,ob.getQuantity_in_the_set());
            prSt.setDouble(3, ob.getFrequency());
            prSt.setString(4, ob.getTimings());
            prSt.setInt(5,ob.getId());
            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void setMouse(Mouse ob) {
        ResultSet resSet=null;
        String insert= "INSERT INTO " + Const.PRODUCT_TABLE + "("+ Const.PRODUCT_NAME +
                ","+ Const.PRODUCT_PRICE+ ","+ Const.PRODUCT_MAKER+")"
                + "VALUES(?,?,?)";
        try {
            PreparedStatement prSt=getDbConnection().prepareStatement(insert);
            prSt.setString(1,ob.getName());
            prSt.setDouble(2, ob.getPrice());
            prSt.setString(3,ob.getMaker());
            prSt.executeUpdate();

            String select="SELECT "+ Const.PRODUCT_ID+ " FROM " + Const.PRODUCT_TABLE + " WHERE "+ Const.PRODUCT_NAME
                    + "=?";

            prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1,ob.getName());
            resSet=prSt.executeQuery();
            if(resSet.next()) {
                ob.setId(resSet.getInt(1));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        insert= "INSERT INTO " + Const.MOUSE_TABLE + "("+Const.MOUSE_RGB+ ","+ Const.MOUSE_DPI+
                ","+ Const.MOUSE_WIRELESS+ ","+ Const.MOUSE_PRODUCT_ID+")"
                + "VALUES(?,?,?,?)";
        try {
            PreparedStatement prSt=getDbConnection().prepareStatement(insert);
            prSt.setInt(1,ob.isRgb());
            prSt.setInt(2,ob.getDPI());
            prSt.setInt(3, ob.isWireless());
            prSt.setInt(4,ob.getId());
            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void setPowerBlock(Power_block ob) {
        ResultSet resSet=null;
        String insert= "INSERT INTO " + Const.PRODUCT_TABLE + "("+ Const.PRODUCT_NAME +
                ","+ Const.PRODUCT_PRICE+ ","+ Const.PRODUCT_MAKER+")"
                + "VALUES(?,?,?)";
        try {
            PreparedStatement prSt=getDbConnection().prepareStatement(insert);
            prSt.setString(1,ob.getName());
            prSt.setDouble(2, ob.getPrice());
            prSt.setString(3,ob.getMaker());
            prSt.executeUpdate();

            String select="SELECT "+ Const.PRODUCT_ID+ " FROM " + Const.PRODUCT_TABLE + " WHERE "+ Const.PRODUCT_NAME
                    + "=?";

            prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1,ob.getName());
            resSet=prSt.executeQuery();
            if(resSet.next()) {
                ob.setId(resSet.getInt(1));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        insert= "INSERT INTO " + Const.POWER_BLOCK_TABLE + "("+Const.POWER_BLOCK_POWER+ ","+ Const.POWER_BLOCK_CERTIFICATE+
                ","+ Const.POWER_BLOCK_PRODUCT_ID+")"
                + "VALUES(?,?,?)";
        try {
            PreparedStatement prSt=getDbConnection().prepareStatement(insert);
            prSt.setInt(1,ob.getPower());
            prSt.setString(2,ob.getCertificate());
            prSt.setInt(3,ob.getId());
            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void setMother_board(Mother_board ob) {
        ResultSet resSet=null;
        String insert= "INSERT INTO " + Const.PRODUCT_TABLE + "("+ Const.PRODUCT_NAME +
                ","+ Const.PRODUCT_PRICE+ ","+ Const.PRODUCT_MAKER+")"
                + "VALUES(?,?,?)";
        try {
            PreparedStatement prSt=getDbConnection().prepareStatement(insert);
            prSt.setString(1,ob.getName());
            prSt.setDouble(2, ob.getPrice());
            prSt.setString(3,ob.getMaker());
            prSt.executeUpdate();

            String select="SELECT "+ Const.PRODUCT_ID+ " FROM " + Const.PRODUCT_TABLE + " WHERE "+ Const.PRODUCT_NAME
                    + "=?";

            prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1,ob.getName());
            resSet=prSt.executeQuery();
            if(resSet.next()) {
                ob.setId(resSet.getInt(1));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        insert= "INSERT INTO " + Const.MOTHER_BOARD_TABLE + "("+Const.MOTHER_BOARD_SOCKET_TYPE+ ","+ Const.MOTHER_BOARD_RGB+
                ","+ Const.MOTHER_BOARD_PRODUCT_ID+")"
                + "VALUES(?,?,?)";
        try {
            PreparedStatement prSt=getDbConnection().prepareStatement(insert);
            prSt.setString(1,ob.getSocket_type());
            prSt.setInt(2,ob.isRgb());
            prSt.setInt(3,ob.getId());
            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<User> getUsers()
    {

        ResultSet resSet=null;
        ArrayList<User> list =new ArrayList<>();

        String select="SELECT * FROM " + Const.USERS_TABLE;

        try {
            PreparedStatement prSt=getDbConnection().prepareStatement(select);
            resSet=prSt.executeQuery();
            while(resSet.next())
            {
                User ob = new User(resSet.getInt(1),resSet.getString(2),resSet.getString(3),
                        resSet.getInt(5),resSet.getInt(4));
                list.add(ob);
            }
            return list;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public void changeLocked(User ob)
    {
        if(ob.isLocked==0)
        {
            ob.setIsLocked(1);
        }
        else {
            ob.setIsLocked(0);
        }
        String update="UPDATE "+ Const.USERS_TABLE+" SET " + Const.USER_STATUS + " = " +ob.getIsLocked() + " WHERE "+ Const.USER_ID + " = "+ob.getId() ;
        try {
            PreparedStatement prSt=getDbConnection().prepareStatement(update);
            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void changeStatus(User ob)
    {
        if(ob.isAdmin==0)
        {
            ob.setIsAdmin(1);
        }
        else {
            ob.setIsAdmin(0);
        }
        String update="UPDATE "+ Const.USERS_TABLE+" SET " + Const.USER_ADMIN + " = " +ob.getIsAdmin() + " WHERE "+ Const.USER_ID + " = "+ob.getId() ;
        try {
            PreparedStatement prSt=getDbConnection().prepareStatement(update);
            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteProduct(Product ob)
    {

        String delete="DELETE FROM "+ Const.PRODUCT_TABLE+ " WHERE "+ Const.PRODUCT_ID + " = "+ob.getId() ;
        try {
            PreparedStatement prSt=getDbConnection().prepareStatement(delete);
            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void changePassword(User ob)
    {
        String update="UPDATE  "+ Const.USERS_TABLE+ " SET "+ Const.USER_PASSWORD + " = "+ "'"+ob.getPassword() +"'"+ " WHERE "+ Const.USER_ID + " = "+ob.getId() ;
        try {
            PreparedStatement prSt=getDbConnection().prepareStatement(update);
            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Mother_board> getMotherBoard()
    {

        ResultSet resSet=null;
        ArrayList<Mother_board> list =new ArrayList<>();

        String select="SELECT * FROM " + Const.PRODUCT_TABLE +","+ Const.MOTHER_BOARD_TABLE +" WHERE "
                + Const.MOTHER_BOARD_PRODUCT_ID + " = " + Const.PRODUCT_ID;

        try {
            PreparedStatement prSt=getDbConnection().prepareStatement(select);
            resSet=prSt.executeQuery();
            while(resSet.next())
            {
                Mother_board cpu = new Mother_board(resSet.getInt(1),resSet.getDouble(3),resSet.getString(2),
                        resSet.getString(4),resSet.getString(6),resSet.getInt(7));
                list.add( cpu);

            }
            return list;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public ArrayList<Ram> getRAM()
    {

        ResultSet resSet=null;
        ArrayList<Ram> list =new ArrayList<>();

        String select="SELECT * FROM " + Const.PRODUCT_TABLE +","+ Const.RAM_TABLE +" WHERE "
                + Const.RAM_PRODUCT_ID + " = " + Const.PRODUCT_ID;

        try {
            PreparedStatement prSt=getDbConnection().prepareStatement(select);
            resSet=prSt.executeQuery();
            while(resSet.next())
            {
                Ram cpu = new Ram(resSet.getInt(1),resSet.getDouble(3),resSet.getString(2),
                        resSet.getString(4),resSet.getInt(5),resSet.getInt(6),resSet.getDouble(7)
                        ,resSet.getString(8));
                list.add( cpu);

            }
            return list;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public ArrayList<Graphics_card> getGraphicsCard()
    {

        ResultSet resSet=null;
        ArrayList<Graphics_card> list =new ArrayList<>();

        String select="SELECT * FROM " + Const.PRODUCT_TABLE +","+ Const.GRAPHICS_CARD_TABLE +" WHERE "
                + Const.GRAPHICS_CARD_PRODUCT_ID + " = " + Const.PRODUCT_ID;

        try {
            PreparedStatement prSt=getDbConnection().prepareStatement(select);
            resSet=prSt.executeQuery();
            while(resSet.next())
            {
                Graphics_card cpu = new Graphics_card(resSet.getInt(1),resSet.getDouble(3),resSet.getString(2),
                        resSet.getString(4),resSet.getDouble(5),resSet.getInt(6),resSet.getInt(7));
                list.add( cpu);

            }
            return list;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Power_block> getPowerBlock()
    {

        ResultSet resSet=null;
        ArrayList<Power_block> list =new ArrayList<>();

        String select="SELECT * FROM " + Const.PRODUCT_TABLE +","+ Const.POWER_BLOCK_TABLE +" WHERE "
                + Const.POWER_BLOCK_PRODUCT_ID + " = " + Const.PRODUCT_ID;

        try {
            PreparedStatement prSt=getDbConnection().prepareStatement(select);
            resSet=prSt.executeQuery();
            while(resSet.next())
            {
                Power_block cpu = new Power_block(resSet.getInt(1),resSet.getDouble(3),resSet.getString(2),
                        resSet.getString(4),resSet.getInt(5),resSet.getString(6));
                list.add( cpu);

            }
            return list;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Screen> getScreen()
    {

        ResultSet resSet=null;
        ArrayList<Screen> list =new ArrayList<>();

        String select="SELECT * FROM " + Const.PRODUCT_TABLE +","+ Const.SCREEN_TABLE +" WHERE "
                + Const.SCREEN_PRODUCT_ID + " = " + Const.PRODUCT_ID;

        try {
            PreparedStatement prSt=getDbConnection().prepareStatement(select);
            resSet=prSt.executeQuery();
            while(resSet.next())
            {
                Screen cpu = new Screen(resSet.getInt(1),resSet.getDouble(3),resSet.getString(2),
                        resSet.getString(4),resSet.getDouble(5),resSet.getString(6),resSet.getString(7));
                list.add( cpu);

            }
            return list;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Mouse> getMouse()
    {

        ResultSet resSet=null;
        ArrayList<Mouse> list =new ArrayList<>();

        String select="SELECT * FROM " + Const.PRODUCT_TABLE +","+ Const.MOUSE_TABLE +" WHERE "
                + Const.MOUSE_PRODUCT_ID + " = " + Const.PRODUCT_ID;

        try {
            PreparedStatement prSt=getDbConnection().prepareStatement(select);
            resSet=prSt.executeQuery();
            while(resSet.next())
            {
                Mouse cpu = new Mouse(resSet.getInt(1),resSet.getDouble(3),resSet.getString(2),
                        resSet.getString(4),resSet.getInt(5),resSet.getInt(6),resSet.getInt(7));
                list.add( cpu);

            }
            return list;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Keyboard> getKeyboard()
    {

        ResultSet resSet=null;
        ArrayList<Keyboard> list =new ArrayList<>();

        String select="SELECT * FROM " + Const.PRODUCT_TABLE +","+ Const.KEYBOARD_TABLE +" WHERE "
                + Const.KEYBOARD_PRODUCT_ID + " = " + Const.PRODUCT_ID;

        try {
            PreparedStatement prSt=getDbConnection().prepareStatement(select);
            resSet=prSt.executeQuery();
            while(resSet.next())
            {
                Keyboard cpu = new Keyboard(resSet.getInt(1),resSet.getDouble(3),resSet.getString(2),
                        resSet.getString(4),resSet.getString(7),resSet.getString(5),resSet.getInt(6));
                list.add( cpu);

            }
            return list;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public  void setBuy(ArrayList<Product> list,User us)
    {

        ResultSet resSet=null;
        int size=list.size();
        String insert= "INSERT INTO " + Const.BUYING_TABLE + "("+ Const.BUYING_USERS_ID+","+ Const.BUYING_PRODUCT_ID+")"
                + " VALUES(?,?)";
        for(int i=0;i<list.size()-1;i++)
        {
            insert+=",(?,?)";
        }
        try {
            PreparedStatement prSt=getDbConnection().prepareStatement(insert);
            for(int i=0,j=1;i<list.size();i++,j+=2)
            {
                prSt.setInt(j,us.getId());
                prSt.setInt(j+1,list.get(i).getId());
            }

            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Order> getOrderList()
    {

        ResultSet resSet=null;
        ArrayList<Order> list =new ArrayList<>();

        String select="SELECT * FROM " + Const.BUYING_TABLE+","+Const.PRODUCT_TABLE+" WHERE "+Const.BUYING_PRODUCT_ID+"="+Const.PRODUCT_ID;

        try {
            PreparedStatement prSt=getDbConnection().prepareStatement(select);
            resSet=prSt.executeQuery();
            while(resSet.next())
            {
                Order cpu = new Order(resSet.getInt(1),resSet.getInt(2),resSet.getInt(3),
                        resSet.getDouble(6),resSet.getString(5),resSet.getString(7));
                list.add( cpu);
            }
            return list;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteOrder(Order ob)
    {

        String delete="DELETE FROM "+ Const.BUYING_TABLE+ " WHERE "+ Const.BUYING_ID_BUYING + " = "+ob.getOrder_id() ;
        try {
            PreparedStatement prSt=getDbConnection().prepareStatement(delete);
            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Order> getUserOrderList(User us)
    {

        ResultSet resSet=null;
        ArrayList<Order> list =new ArrayList<>();

        String select="SELECT * FROM " + Const.BUYING_TABLE+","+Const.PRODUCT_TABLE+" WHERE "
                +Const.BUYING_PRODUCT_ID+"="+Const.PRODUCT_ID +" AND "+ Const.BUYING_USERS_ID+"="+us.getId();

        try {
            PreparedStatement prSt=getDbConnection().prepareStatement(select);
            resSet=prSt.executeQuery();
            while(resSet.next())
            {
                Order cpu = new Order(resSet.getInt(1),resSet.getInt(2),resSet.getInt(3),
                        resSet.getDouble(6),resSet.getString(5),resSet.getString(7));
                list.add( cpu);
            }
            return list;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
