package rocket;

import struct.Item;

interface SpaceShip {
    boolean launch();
    boolean land();
    boolean canCarry(Item item);
    void carry(Item item);
}
