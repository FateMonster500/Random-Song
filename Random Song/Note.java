public class Note
{
  private String tone;
  private int duration;
  
  public Note(String tone, int duration)
  {
    this.tone = tone;
    this.duration = duration;
  }
  
  public String getTone()
  {
    return tone;
  }
  
  public int getDuration()
  {
    return duration;
  }
}