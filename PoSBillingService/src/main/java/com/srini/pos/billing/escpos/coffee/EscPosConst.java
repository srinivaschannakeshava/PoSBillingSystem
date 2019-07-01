package com.srini.pos.billing.escpos.coffee;

/*
 * Use of this source code is governed by the MIT license that can be
 * found in the LICENSE file.
 */

public interface EscPosConst {

	/**
	 *
	 */
	public final String version = "1.0.5";
	public final int NUL = 0;
	public final int LF = 10;
	public final int ESC = 27;
	public final int GS = 29;

	/**
	 * Values for print justification.
	 * 
	 * @see Style#setJustification(escpos.EscPosConst.Justification)
	 */
	public enum Justification {
		Left_Default(48), Center(49), Right(50);
		public int value;

		private Justification(int value) {
			this.value = value;
		}
	}

}
