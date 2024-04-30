package nhom6.example.Planta.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlantResponseOfMyPlant {
	private int id;
	private String name;
	private String typePlant;
	private String mainImage;
    private String secondaryImage;
    private String typeSoil;
    private String matureSize;
    private String matureTime;
    private String description;
}
