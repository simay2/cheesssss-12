package chess.pieces;

import java.util.List;

import chess.board.Board;
import chess.board.Move;

public abstract class Piece {
	
	protected final int piecePossition;
	protected final Alliance pieceAlliance;
	
	Piece(final piecePossition, final Alliance pieceAlliance) {
		this.pieceAlliance = pieceAlliance;
		this.piecePossition = piecePossition;
	}
	
	public abstract List<Move> calculateLegalMoves(final Board board);

}
