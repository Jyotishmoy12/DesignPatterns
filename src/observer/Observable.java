package observer;

// to be observable we always need to have these 3 methods mandatory
public interface Observable {
  public void registerObserver(Observer observer);

  public void removeObserver(Observer observer);

  public void notifyObservers();
}
