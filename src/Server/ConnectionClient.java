package Server;

import ProductTree.*;
import User.User;
import User.Order;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ConnectionClient {
    static public OutputStream os=null;
    static public InputStream is=null;
    static public ObjectInputStream ois=null;
    static public ObjectOutputStream oos=null;

    static public  DatabaseHandler dbHandler=new DatabaseHandler();


    public ConnectionClient(Socket sock)
    {
        try {
            is = sock.getInputStream();
            os = sock.getOutputStream();
            oos = new ObjectOutputStream(os);
            ois = new ObjectInputStream(is);

        }
        catch (IOException ex)
        {
            throw  new RuntimeException(ex);
        }
    }
    public void registration()
    {

        try {
            User us =(User)ois.readObject();
            int code=dbHandler.regUser(us.login,us.password,us.isLocked, us.isAdmin);
            os.write(code);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
    public void codeRead()
    {
        byte code;
        try {
             code= (byte)is.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        switch(code) {
            case 0: registration();break;
            case 1: logIn();break;
            case 2: getProduct();break;
            case 3: addCPU(); break;
            case 4: addGraphicsCard();break;
            case 5: addScreen();break;
            case 6: addKeyboard();break;
            case 7: addRAM();break;
            case 8: addMouse();break;
            case 9: addPowerBlock();break;
            case 10: addMother_board();break;
            case 11: getUsers();break;
            case 12: changeLocked();break;
            case 13: changeStatus();break;
            case 14: deleteProduct();break;
            case 15: changePassword();break;
            case 16: getCPU();break;
            case 17: getMotherBoard();break;
            case 18: getRAM();break;
            case 19: getGraphicsCard();break;
            case 20: getPowerBlock();break;
            case 21: getScreen();break;
            case 22: getMouse();break;
            case 23: getKeyboard();break;
            case 24: addBuy();break;
            case 25: getOrderList();break;
            case 26: deleteOrder();break;
            case 27: getUserOrderList();break;
        }
    }
    public void logIn()
    {
        try {
            User us =(User)ois.readObject();
            oos.writeObject(dbHandler.getUser(us));
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void getProduct()
    {
        ArrayList<Product> list=new ArrayList<>();
        list=dbHandler.getProduct();
        try {
            oos.writeObject(list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void addCPU()
    {
        try {
            dbHandler.setCPU((CPU)ois.readObject());
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void addGraphicsCard()
    {
        try {
            dbHandler.setGraphicsCard((Graphics_card) ois.readObject());
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void addScreen()
    {
        try {
            dbHandler.setScreen((Screen)ois.readObject());
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void addKeyboard()
    {
        try {
            dbHandler.setKeyboard((Keyboard)ois.readObject());
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void addMouse()
    {
        try {
            dbHandler.setMouse((Mouse)ois.readObject());
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void addPowerBlock()
    {
        try {
            dbHandler.setPowerBlock((Power_block)ois.readObject());
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void addRAM()
    {
        try {
            dbHandler.setRam((Ram)ois.readObject());
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void addMother_board()
    {
        try {
            dbHandler.setMother_board((Mother_board)ois.readObject());
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void getUsers()
    {
        ArrayList<User> list=new ArrayList<>();
        list=dbHandler.getUsers();
        try {
            oos.writeObject(list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void changeLocked()
    {
        try {
            dbHandler.changeLocked((User)ois.readObject());
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public void changeStatus()
    {
        try {
            dbHandler.changeStatus((User)ois.readObject());
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteProduct()
    {
        try {
            dbHandler.deleteProduct((Product)ois.readObject());
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public void changePassword()
    {

        try {
            dbHandler.changePassword((User)ois.readObject());

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public void getCPU()
    {
        ArrayList<CPU> list=new ArrayList<>();
        list=dbHandler.getCPU();
        try {
            oos.writeObject(list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void getMotherBoard()
    {
        ArrayList<Mother_board> list=new ArrayList<>();
        list=dbHandler.getMotherBoard();
        try {
            oos.writeObject(list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void getRAM()
    {
        ArrayList<Ram> list=new ArrayList<>();
        list=dbHandler.getRAM();
        try {
            oos.writeObject(list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void getGraphicsCard()
    {
        ArrayList<Graphics_card> list=new ArrayList<>();
        list=dbHandler.getGraphicsCard();
        try {
            oos.writeObject(list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void getPowerBlock()
    {
        ArrayList<Power_block> list=new ArrayList<>();
        list=dbHandler.getPowerBlock();
        try {
            oos.writeObject(list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void getScreen()
    {
        ArrayList<Screen> list=new ArrayList<>();
        list=dbHandler.getScreen();
        try {
            oos.writeObject(list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void getMouse()
    {
        ArrayList<Mouse> list=new ArrayList<>();
        list=dbHandler.getMouse();
        try {
            oos.writeObject(list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void getKeyboard()
    {
        ArrayList<Keyboard> list=new ArrayList<>();
        list=dbHandler.getKeyboard();
        try {
            oos.writeObject(list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void addBuy()
    {
        try {
            dbHandler.setBuy((ArrayList<Product>)ois.readObject(),(User)ois.readObject());
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void getOrderList()
    {
        ArrayList<Order> list;
        list=dbHandler.getOrderList();
        try {
            oos.writeObject(list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteOrder()
    {
        try {
            dbHandler.deleteOrder((Order)ois.readObject());
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public void getUserOrderList()
    {
        ArrayList<Order> list;
        try {
            list=dbHandler.getUserOrderList((User)ois.readObject());
            oos.writeObject(list);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
