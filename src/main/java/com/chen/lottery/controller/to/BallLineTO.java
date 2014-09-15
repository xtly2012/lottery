package com.chen.lottery.controller.to;

public class BallLineTO
{
     private String name;
     
     private Integer[] value;
     
     private String color;
     
     private Integer line_width;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer[] getValue()
    {
        return value;
    }

    public void setValue(Integer[] value)
    {
        this.value = value;
    }

    public String getColor()
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    public Integer getLine_width()
    {
        return line_width;
    }

    public void setLine_width(Integer line_width)
    {
        this.line_width = line_width;
    }
     
}
