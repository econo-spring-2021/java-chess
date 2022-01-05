package Chess.dto;

public class MovementDto {

    private int source;
    private int destination;

    public MovementDto() {
    }

    public MovementDto(int source, int destination) {
        this.source = source;
        this.destination = destination;
    }

    public int getSource() {
        return source;
    }

    public int getDestination() {
        return destination;
    }
}
