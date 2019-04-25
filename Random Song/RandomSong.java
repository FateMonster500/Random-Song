import java.util.*;

public class RandomSong
{
  private List<Note> melody = new ArrayList<Note>();
  private String name;
  private int duration;
  private int num;
  private boolean which;
  private boolean five;
  
  public RandomSong(String name, int duration)
  {
    this.name = name;
    this.duration = duration;
    for(int i = 0; i < 5; i++)
    {
      melody.add(new Note(name, duration));
    }
  }
  
     public RandomSong(String name, int duration, int num)
   {
     this.name = name;
     this.duration = duration;
     for(int i = 0; i < num; i++)
     {
       melody.add(new Note(name, duration));
     }
   }
  
  public RandomSong(String name, int duration, int num, boolean which)
  {
    //3
    this.name = name;
    this.duration = duration;
    this.num = num;
    this.which = which;
    melody.add(new Note(name, duration));
    for(int i = 1; i < num - 1; i++)
    {
      int n = retNum(melody.get(i - 1).getTone());
      double a  = Math.random();
      if(n == 6)
      {
        melody.add(new Note(retNote(n - (int)(Math.random()*3)), (int)(Math.random() * 4 + 1)));
      }
      if(n == 5)
      {
        if(a >= .5)
        {
          melody.add(new Note(retNote(n + (int)(Math.random()*2)), (int)(Math.random() * 4 + 1)));
        }
        else
          melody.add(new Note(retNote(n - (int)(Math.random()*3)), (int)(Math.random() * 4 + 1)));
      }
    if(n == 4 || n == 3 || n == 2)
    {
      if(a >= .5)
        {
          melody.add(new Note(retNote(n + (int)(Math.random()*3)), (int)(Math.random() * 4 +1)));
        }
        else
          melody.add(new Note(retNote(n - (int)(Math.random()*3)), (int)(Math.random() * 4 +1)));
      }
    if(n == 1)
    {
      if(a >=.5)
      {
        melody.add(new Note(retNote(n + (int)(Math.random()*3)), (int)(Math.random() * 4 + 1)));
      }
      else
        melody.add(new Note(retNote(n - (int)(Math.random()*2)), (int)(Math.random()*4 + 1)));
    }
    if(n == 0)
    {
      melody.add(new Note(retNote(n + (int)(Math.random()*3)), (int)(Math.random()*4 + 1)));
    }
    }
    melody.add(new Note(name, duration));
  }

  public RandomSong(String name, int duration, int num, int repeat)
  {/////4
    this.name = name;
    this.duration = duration;
    this.num = num;
    this.which = which;
    List<Note> melodyrep = new ArrayList<Note>();
    melodyrep.add(new Note(name, duration));
    for(int j = 0; j < 2; j++)
      {
        for(int i = 1; i < num - 1; i++)
    {
      int n = retNum(melodyrep.get(i - 1).getTone());
      double a  = Math.random();
      if(n == 6)
      {
        melodyrep.add(new Note(retNote(n - (int)(Math.random()*3)), (int)(Math.random() * 4 + 1)));
      }
      if(n == 5)
      {
        if(a >= .5)
        {
          melodyrep.add(new Note(retNote(n + (int)(Math.random()*2)), (int)(Math.random() * 4 + 1)));
        }
        else
          melodyrep.add(new Note(retNote(n - (int)(Math.random()*3)), (int)(Math.random() * 4 + 1)));
      }
    if(n == 4 || n == 3 || n == 2)
    {
      if(a >= .5)
        {
          melodyrep.add(new Note(retNote(n + (int)(Math.random()*3)), (int)(Math.random() * 4 +1)));
        }
        else
          melodyrep.add(new Note(retNote(n - (int)(Math.random()*3)), (int)(Math.random() * 4 +1)));
      }
    if(n == 1)
    {
      if(a >=.5)
      {
        melodyrep.add(new Note(retNote(n + (int)(Math.random()*3)), (int)(Math.random() * 4 + 1)));
      }
      else
        melodyrep.add(new Note(retNote(n - (int)(Math.random()*2)), (int)(Math.random()*4 + 1)));
    }
    if(n == 0)
    {
      melodyrep.add(new Note(retNote(n + (int)(Math.random()*3)), (int)(Math.random()*4 + 1)));
    }
    melodyrep.add(new Note(name, duration));
  }
    }
    for(int r = 0; r < repeat; r++)
    {
      for(int k = 0; k < melodyrep.size(); k++)
      {
        melody.add(melodyrep.get(k));
      }
    }
  }
  
  public RandomSong(String name, int duration, int num, int repeat, boolean five)
  {
    this.name = name;
    this.duration = duration;
    this.num = num;
    this.five = five;
    List<Note> melodyrep = new ArrayList<Note>();
    melodyrep.add(new Note(name, duration));
      for(int j = 0; j < 2; j++)
      {
        for(int i = 1; i < num - 1; i++)
    {
      int n = retNum(melodyrep.get(i - 1).getTone());
      double a  = Math.random();
      if(n == 6)
      {
        melodyrep.add(new Note(retNote(n - (int)(Math.random()*3)), (int)(Math.random() * 4 + 1)));
      }
      if(n == 5)
      {
        if(a >= .5)
        {
          melodyrep.add(new Note(retNote(n + (int)(Math.random()*2)), (int)(Math.random() * 4 + 1)));
        }
        else
          melodyrep.add(new Note(retNote(n - (int)(Math.random()*3)), (int)(Math.random() * 4 + 1)));
      }
    if(n == 4 || n == 3 || n == 2)
    {
      if(a >= .5)
        {
          melodyrep.add(new Note(retNote(n + (int)(Math.random()*3)), (int)(Math.random() * 4 +1)));
        }
        else
          melodyrep.add(new Note(retNote(n - (int)(Math.random()*3)), (int)(Math.random() * 4 +1)));
      }
    if(n == 1)
    {
      if(a >=.5)
      {
        melodyrep.add(new Note(retNote(n + (int)(Math.random()*3)), (int)(Math.random() * 4 + 1)));
      }
      else
        melodyrep.add(new Note(retNote(n - (int)(Math.random()*2)), (int)(Math.random()*4 + 1)));
    }
    if(n == 0)
    {
      melodyrep.add(new Note(retNote(n + (int)(Math.random()*3)), (int)(Math.random()*4 + 1)));
    }
    melodyrep.add(new Note(name, duration));
  }
      }
    for(int r = 0; r < repeat - 1; r++)
    {
      for(int k = 0; k < melodyrep.size(); k++)
      {
        melody.add(melodyrep.get(k));
      }
    }
     melodyrep.add(new Note(name, duration));
    for(int i = 1; i < num - 1; i++)
    {
      int n = retNum(melodyrep.get(i - 1).getTone());
      double a  = Math.random();
      if(n == 6)
      {
        melodyrep.add(new Note(retNote(n - (int)(Math.random()*3)), (int)(Math.random() * 4 + 1)));
      }
      if(n == 5)
      {
        if(a >= .5)
        {
          melodyrep.add(new Note(retNote(n + (int)(Math.random()*2)), (int)(Math.random() * 4 + 1)));
        }
        else
          melodyrep.add(new Note(retNote(n - (int)(Math.random()*3)), (int)(Math.random() * 4 + 1)));
      }
    if(n == 4 || n == 3 || n == 2)
    {
      if(a >= .5)
        {
          melodyrep.add(new Note(retNote(n + (int)(Math.random()*3)), (int)(Math.random() * 4 +1)));
        }
        else
          melodyrep.add(new Note(retNote(n - (int)(Math.random()*3)), (int)(Math.random() * 4 +1)));
      }
    if(n == 1)
    {
      if(a >=.5)
      {
        melodyrep.add(new Note(retNote(n + (int)(Math.random()*3)), (int)(Math.random() * 4 + 1)));
      }
      else
        melodyrep.add(new Note(retNote(n - (int)(Math.random()*2)), (int)(Math.random()*4 + 1)));
    }
    if(n == 0)
    {
      melodyrep.add(new Note(retNote(n + (int)(Math.random()*3)), (int)(Math.random()*4 + 1)));
    }
    melodyrep.add(new Note(name, duration));
  }
     for(int k = 0; k < melodyrep.size(); k++)
      {
        melody.add(melodyrep.get(k));
      }
  }
  
   public String toString()
   {
     String ret = "";
     for(int i = 0; i < melody.size(); i++)
     {
       ret = ret + melody.get(i).getTone();
     }
     ret = ret +" \n";
     for(int j = 0; j < melody.size(); j++)
     {
       ret = ret + String.valueOf(melody.get(j).getDuration());
     }
     return ret;
   }
   
   public List<Note> getMelody()
   {
     return melody;
   }
  
   public int retNum(String letter)
   {
     String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
       for(int i = 0; i < alphabet.length; i++)
     {
       if(alphabet[i].equals(letter))
       {
         return i;
       }
     }
       return 0;
   }
   
   public String retNote(int num)
   {
     String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
     return alphabet[num];
   }
   
   
   
   }