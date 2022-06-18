export class Chore {

  id: number | null;
  name: string | null;
  price: number | null;

  constructor(
    id: number = 0,
    name: string = '',
    price: number = 0
  ){
    this.id = id;
    this.name = name;
    this.price = price;
  }

}
