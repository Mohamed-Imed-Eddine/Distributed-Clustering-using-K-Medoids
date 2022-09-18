
import java.rmi.Remote; 
import java.rmi.RemoteException;


public interface Interface extends Remote{
    
    public int get_nb_results() throws RemoteException;
    public Entry get_data()throws RemoteException;
    public void prepare_data(int choice_data_set,int nb_iteration) throws RemoteException;
    public void return_solution(Solution s) throws RemoteException;
    public void set_nb_centers(int val)throws RemoteException;
    public Solution get_best_solution() throws RemoteException;
    public boolean stop_algorithm()throws RemoteException;
    public Solution get_final_solution() throws RemoteException;
    public int get_nb_iterations()  throws RemoteException;

}