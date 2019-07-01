import { Items } from './items';

export class Bill {
    billNo?: number;
    items: Items[];
    totalPrice: number;
    date?: string;
}
