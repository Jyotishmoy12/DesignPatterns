package observer;

// to be an observer we need to have these 1 method
public interface Observer {
  public void update(int temperature, int humidity);
}
