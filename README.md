# blum
Blum implements an algorithm for determining drawer box dimensions using [blum runner systems](https://www.blum.com/us/en/products/runnersystems/) given a cabinet's dimensions.

## Example
```
How wide is your cabinet?
15.75
How tall is your cabinet?
34.5
How deep is your cabinet?
21.75
You created a cabinet:
  Cabinet{
    dimensions=15.75x34.5x21.75,
    sideMaterial=Material{THREE_QUARTER},
    backMaterial=Material{QUARTER},
    panels=
      Cut{name=side,  dimensions=34.5x21.75, material=Material{THREE_QUARTER}},
      Cut{name=side,  dimensions=34.5x21.75, material=Material{THREE_QUARTER}},
      Cut{name=bottom,  dimensions=15.0x21.75, material=Material{THREE_QUARTER}},
      Cut{name=back,  dimensions=15.0x34.125, material=Material{QUARTER}},
    runners=
      Cut{name=runner,  dimensions=14.25x3.0, material=Material{THREE_QUARTER}},
      Cut{name=runner,  dimensions=14.25x3.0, material=Material{THREE_QUARTER}},
      Cut{name=runner,  dimensions=14.25x3.0, material=Material{THREE_QUARTER}},
      Cut{name=runner,  dimensions=14.25x3.0, material=Material{THREE_QUARTER}}
  }
```
