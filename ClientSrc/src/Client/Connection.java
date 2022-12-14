package Client;

import ProductTree.*;
import User.User;
import User.Order;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class Connection {

    static public Socket sock=null;
    static public OutputStream os=null;
    static public InputStream is=null;
    static public ObjectInputStream ois=null;
    static public ObjectOutputStream oos=null;


    public Connection()
    {
        try {
            sock = new Socket("127.0.0.1", 1024);
            is = sock.getInputStream();
            os = sock.getOutputStream();
            oos = new ObjectOutputStream(sock.getOutputStream());
            ois = new ObjectInputStream(sock.getInputStream());
        }
        catch (IOException ex)
        {
            throw  new RuntimeException(ex);
        }
    }
    public byte registration(String login,String password,int locked , int admin)
    {

        byte code=0;
        try {
            os.write(code);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        User us=new User(login,password, locked ,admin);
        try {
            oos.writeObject(us);
            code=(byte)is.read();
            return code;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public User signUp(String login,String password)
    {
        byte code=1;
        try {
            os.write(code);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        User us=new User(login,password);
        try {
            oos.writeObject(us);
            us=(User)ois.readObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return us;

    }
    public ArrayList<Product> getProducts()
    {

        byte code=2;
        ArrayList<Product> list =new ArrayList<>();
        try {
            os.write(code);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
             list =(ArrayList<Product>)ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    public void addCPU(CPU ob)
    {
        byte code=3;
        try {
            os.write(code);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            oos.writeObject(ob);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void addGraphics_card(Graphics_card ob)
    {
        byte code=4;
        try {
            os.write(code);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            oos.writeObject(ob);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void addScreen(Screen ob)
    {
        byte code=5;
        try {
            os.write(code);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            oos.writeObject(ob);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void addKeyboard(Keyboard ob)
    {
        byte code=6;
        try {
            os.write(code);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            oos.writeObject(ob);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void addRam(Ram ob)
    {
        byte code=7;
        try {
            os.write(code);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            oos.writeObject(ob);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addMouse(Mouse ob)
    {
        byte code=8;
        try {
            os.write(code);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            oos.writeObject(ob);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addPower_block(Power_block ob)
    {
        byte code=9;
        try {
            os.write(code);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            oos.writeObject(ob);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void addMother_board(Mother_board ob)
    {
        byte code=10;
        try {
            os.write(code);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            oos.writeObject(ob);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<User> getUsers()
    {

        byte code=11;
        ArrayList<User> list =new ArrayList<>();
        try {
            os.write(code);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            list =(ArrayList<User>)ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    public void changeLocked(User ob)
    {
        byte code=12;
        try {
            os.write(code);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            oos.writeObject(ob);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void changeStatus(User ob)
    {
        byte code=13;
        try {
            os.write(code);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            oos.writeObject(ob);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteProduct(Product ob)
    {
        byte code=14;
        try {
            os.write(code);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            oos.writeObject(ob);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void changePassword(User ob) {
        byte code = 15;
        try {
            os.write(code);
            oos.writeObject(ob);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<CPU> getCPU()
    {

        byte code=16;
        ArrayList<CPU> list =new ArrayList<>();
        try {
            os.write(code);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            list =(ArrayList<CPU>)ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    public ArrayList<Mother_board> getMother_board()
    {

        byte code=17;
        ArrayList<Mother_board> list =new ArrayList<>();
        try {
            os.write(code);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            list =(ArrayList<Mother_board>)ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    public ArrayList<Ram> getRAM()
    {

        byte code=18;
        ArrayList<Ram> list =new ArrayList<>();
        try {
            os.write(code);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            list =(ArrayList<Ram>)ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    public ArrayList<Graphics_card> getGraphicsCard()
    {

        byte code=19;
        ArrayList<Graphics_card> list =new ArrayList<>();
        try {
            os.write(code);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            list =(ArrayList<Graphics_card>)ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    public ArrayList<Power_block> getPowerBlock()
    {

        byte code=20;
        ArrayList<Power_block> list =new ArrayList<>();
        try {
            os.write(code);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            list =(ArrayList<Power_block>)ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    public ArrayList<Screen> getScreen()
    {

        byte code=21;
        ArrayList<Screen> list =new ArrayList<>();
        try {
            os.write(code);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            list =(ArrayList<Screen>)ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    public ArrayList<Mouse> getMouse()
    {

        byte code=22;
        ArrayList<Mouse> list =new ArrayList<>();
        try {
            os.write(code);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            list =(ArrayList<Mouse>)ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    public ArrayList<Keyboard> getKeyboard()
    {

        byte code=23;
        ArrayList<Keyboard> list =new ArrayList<>();
        try {
            os.write(code);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            list =(ArrayList<Keyboard>)ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    public void setBuyList(ArrayList<Product> BuyList,User us)
    {

        byte code=24;
        try {
            os.write(code);
            oos.writeObject(BuyList);
            oos.writeObject(us);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Order> getOrderList()
    {
        ArrayList<Order> list = new ArrayList<>();
        byte code=25;
        try {
            os.write(code);
            list =(ArrayList<Order>)ois.readObject();
            return list;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteOrder(Order ob)
    {
        byte code=26;
        try {
            os.write(code);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            oos.writeObject(ob);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Order> getUserOrderList(User us)
    {
        ArrayList<Order> list = new ArrayList<>();
        byte code=27;
        try {
            os.write(code);
            oos.writeObject(us);
            list =(ArrayList<Order>)ois.readObject();
            return list;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
