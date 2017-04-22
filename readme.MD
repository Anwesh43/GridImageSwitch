## GridImageSwitch

### Android Library to create a view containing png images arranged in grid which act as switches.

### Usage

#### Include the module in app/build.gradle

```
    dependencies {
        compile project(':gridswitch')
    }
```

#### Create a GridSwitch

```
    GridSwitch gridSwitch = new GridSwitch(this);
```

#### Add a grid element

```
    gridSwitch.addGridElement(bitmap,new OnSelectionListener(){
          public void onSelect() {

          }
          public void onUnSelect() {

          }
    });
```

#### Showing the GridSwitchView

```
    gridSwitch.show();
```


#### Demo

<img src="https://github.com/Anwesh43/GridImageSwitch/blob/master/screencast/gridswitchview.gif" alt="demo of grid image switch" width="300px" height="500px">
